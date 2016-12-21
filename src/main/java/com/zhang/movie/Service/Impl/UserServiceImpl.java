package com.zhang.movie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.movie.Dao.UserDao;
import com.zhang.movie.Model.User;
import com.zhang.movie.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * 返回用户的id
	 */
	public int login(String email) {
		// TODO Auto-generated method stub
		User user = userDao.selectByMail(email);
		if(user == null){
			user = new User();
			user.setEmail(email);
			return userDao.insert(user);
		}
		return user.getId();
	}

}
