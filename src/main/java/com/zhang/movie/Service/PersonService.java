package com.zhang.movie.Service;

import org.springframework.stereotype.Component;

import com.zhang.movie.Model.User;

@Component
public interface PersonService {

	/**
	 * ����һ�����û�
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);

}
