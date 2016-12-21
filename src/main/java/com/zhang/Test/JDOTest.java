package com.zhang.Test;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.zhang.movie.Model.Person;
import com.zhang.movie.tmp.UtilsTest;

public class JDOTest {

	public static void main(String[] args) {
		
		PersistenceManager pm = UtilsTest.getPersistenceManager();
		Transaction tx = UtilsTest.getTransaction();
		

		try {
			
			//插入数据
//			 tx.begin();
//			 Person p = new Person();
//			 p.setName("zhangxinxin");
//			 p.setAge(22);
//			 p.setEmail("zhangxin@163.com");
//			 pm.makePersistent(p);
//			 tx.commit();
			
			
			//查询数据
			tx.begin();
			Query q = pm.newQuery(Person.class,"id>6");//查询一条记录
			
			@SuppressWarnings("unchecked")
			List<Person> list = (List<Person>) q.execute();
			Iterator<Person> it = list.iterator();
			
			while(it.hasNext()){
				Person p = (Person) it.next();
				System.out.println(p.toString());
			}
			
			/**
			 * 删除一条记录
			 */
//			Query pe = pm.newQuery(Person.class,"id==3");
//			Long l = (Long)pe.deletePersistentAll();
//			System.out.println(l);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			UtilsTest.close();
		}
	}
}
