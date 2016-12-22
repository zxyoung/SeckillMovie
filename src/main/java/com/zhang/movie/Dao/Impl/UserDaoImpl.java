package com.zhang.movie.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zhang.movie.Dao.UserDao;
import com.zhang.movie.Model.User;
import com.zhang.movie.Utils.JDOUtil;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	@Qualifier("JDOUtilImpl")
	private JDOUtil jdoUtil;

	public int insert(User user) {
		return (Integer) jdoUtil.insert(user); 
	}

	public boolean update(User user) {
		return jdoUtil.update(user);
	}

	public User selectById(int user_id) {
		return jdoUtil.selectByPK(User.class, user_id);
	}

	public User selectByMail(String email) {
		String sql = "email=="+email;
		return (User) jdoUtil.selectByQuery(User.class, sql);
	}
	
}
