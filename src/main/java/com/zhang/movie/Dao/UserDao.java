package com.zhang.movie.Dao;

import com.zhang.movie.Model.User;

public interface UserDao {

	/**
	 * 添加新用户
	 * 
	 * @param user
	 *            添加用户
	 * @return
	 */
	int insert(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            更新用户
	 * @return
	 */
	boolean update(User user);

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return
	 */
	User selectById(int user_id);

	/**
	 * 根据email查询用户信息
	 * 
	 * @param email
	 *            用户email
	 * @return
	 */
	User selectByMail(String email);
}