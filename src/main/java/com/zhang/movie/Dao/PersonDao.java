package com.zhang.movie.Dao;

import com.zhang.movie.Model.Person;

/**
 * 测试用
 * @author Administrator
 *
 */
public interface PersonDao {
	
	//插入一条记录
	int insert(Person person);
	
	//更新一条记录
	boolean update(Person person);
	
	//根据id查找一个人
	Person selectById(int id);
	
	//
	Person selectByName(String name);
}
