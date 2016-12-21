package com.zhang.movie.Service;

public interface MailService {

	/**
	 * 发送Email
	 * 
	 * @param email
	 *            邮箱地址
	 * @param content
	 *            邮件内容
	 * @return 一个boolean值
	 */
	boolean sendEmail(String email, String content);

	/**
	 * 发送Email
	 * 
	 * @param email
	 *            邮箱地址
	 * @param title
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @return
	 */
	boolean sendEmail(String email, String title, String content);
}
