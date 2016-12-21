package com.zhang.movie.Service;

import org.springframework.stereotype.Component;

import com.zhang.movie.Model.User;

@Component
public interface PersonService {

	/**
	 * 增加一个新用户
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);

}
