package com.zhang.movie.Dao;

import com.zhang.movie.Model.User;

public interface UserDao {

	/**
	 * ������û�
	 * 
	 * @param user
	 *            ����û�
	 * @return
	 */
	int insert(User user);

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 *            �����û�
	 * @return
	 */
	boolean update(User user);

	/**
	 * ����id��ѯ�û���Ϣ
	 * 
	 * @param id
	 *            �û�id
	 * @return
	 */
	User selectById(int user_id);

	/**
	 * ����email��ѯ�û���Ϣ
	 * 
	 * @param email
	 *            �û�email
	 * @return
	 */
	User selectByMail(String email);
}