package com.zhang.movie.Service;

public interface MailService {

	/**
	 * ����Email
	 * 
	 * @param email
	 *            �����ַ
	 * @param content
	 *            �ʼ�����
	 * @return һ��booleanֵ
	 */
	boolean sendEmail(String email, String content);

	/**
	 * ����Email
	 * 
	 * @param email
	 *            �����ַ
	 * @param title
	 *            �ʼ�����
	 * @param content
	 *            �ʼ�����
	 * @return
	 */
	boolean sendEmail(String email, String title, String content);
}
