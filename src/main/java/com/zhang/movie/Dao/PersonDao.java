package com.zhang.movie.Dao;

import com.zhang.movie.Model.Person;

/**
 * ������
 * @author Administrator
 *
 */
public interface PersonDao {
	
	//����һ����¼
	int insert(Person person);
	
	//����һ����¼
	boolean update(Person person);
	
	//����id����һ����
	Person selectById(int id);
	
	//
	Person selectByName(String name);
}
