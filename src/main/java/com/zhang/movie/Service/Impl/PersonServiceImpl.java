package com.zhang.movie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.movie.Dao.PersonDao;
import com.zhang.movie.Model.Person;

/**
 * ≤‚ ‘”√
 * @author Administrator
 *
 */
@Service
public class PersonServiceImpl implements PersonDao{

	@Autowired
	private PersonDao personDao;
	
	public int insert(Person person) {
		// TODO Auto-generated method stub
		return personDao.insert(person);
	}

	public boolean update(Person person) {
		// TODO Auto-generated method stub
		return personDao.update(person);
	}

	public Person selectById(int id) {
		// TODO Auto-generated method stub
		return personDao.selectById(id);
	}

	public Person selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
