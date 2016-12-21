package com.zhang.movie.Service.Impl;

import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.zhang.movie.Service.MailService;

@Service
public class MailServiecImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment environment;

	@Autowired
	private Logger log;

	private LinkedBlockingQueue<SimpleMailMessage> blockingQueue;
	Thread thread;

	public MailServiecImpl() {
		blockingQueue = new LinkedBlockingQueue<SimpleMailMessage>();
		thread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					try {
						SimpleMailMessage simpleMailMessage = blockingQueue.take();
						if (environment.getProperty("email.send.enable").equals("true")) {
							log.debug("正在向" + simpleMailMessage.getTo()[0] + "发送邮件！");
							javaMailSender.send(simpleMailMessage);
							log.debug("发送成功！");
						} else {
							log.debug("发送出错！");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	private SimpleMailMessage createSimpleMailMessage(String title, String email, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(environment.getProperty("spring.mail.username"));
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(title);
		simpleMailMessage.setText(content);
		log.debug("邮件创建成功！");
		return simpleMailMessage;
	}

	public boolean sendEmail(String email, String content) {
		return sendEmail(email, environment.getProperty("email.title"), content);
	}

	public boolean sendEmail(String email, String title, String content) {
		boolean flag = true;
		SimpleMailMessage simpleMailMessage = createSimpleMailMessage(title, email, content);
		try {
			blockingQueue.put(simpleMailMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
			flag = false;
			return flag;
		}
		return flag;
	}

}
