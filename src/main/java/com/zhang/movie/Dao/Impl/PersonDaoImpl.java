package com.zhang.movie.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zhang.movie.Dao.PersonDao;
import com.zhang.movie.Model.Person;
import com.zhang.movie.Utils.JDOUtil;

/**
 * ≤‚ ‘”√
 * @author Administrator
 *
 */
@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
	@Qualifier("JDOUtilImpl")
	private JDOUtil jdoUtil;
	
	
	public int insert(Person person) {
		return (Integer) jdoUtil.insert(person);
	}

	public boolean update(Person person) {
		return jdoUtil.update(person);
	}

	public Person selectById(int id) {
		return jdoUtil.selectByPK(Person.class, id);
	}

	public Person selectByName(String name) {
		String sql = "p_name=="+name;
		return (Person) jdoUtil.selectByQuery(Person.class, sql);
	}

}
