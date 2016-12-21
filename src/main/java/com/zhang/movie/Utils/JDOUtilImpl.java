package com.zhang.movie.Utils;

import java.lang.reflect.Field;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.PrimaryKey;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;


@Repository
public class JDOUtilImpl implements JDOUtil {

	PersistenceManagerFactory persistenceManagerFactory;

	public <T> T selectByPK(Class<T> classname, Object obj) {
		// TODO Auto-generated method stub
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();

		T res = null;
		try {
			res = pm.getObjectById(classname, obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> selectByQuery(Class<T> classame, String sql) {
		// TODO Auto-generated method stub
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();

		List<T> list = null;
		try {
			Query query = pm.newQuery(classame, sql);
			list = (List<T>) query.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}
		return list;
	}

	public <T> Object insert(T object) {
		// TODO Auto-generated method stub
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Object id = null;
		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
			id = getObjectID(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return id;
	}

	private Object getObjectID(Object object) {
		// TODO Auto-generated method stub
		Field[] decFields = object.getClass().getDeclaredFields();
		for (Field field : decFields) {
			PrimaryKey annotation = field.getAnnotation(PrimaryKey.class);
			if (annotation != null) {
				field.setAccessible(true);
				try {
					return field.get(object);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public <T> boolean update(T object) {
		// TODO Auto-generated method stub
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		boolean flat = false;

		try {
			tx.begin();
			Object tmp = pm.getObjectById(object.getClass(), getObjectID(object));
			if (tmp == null) {
				return false;
			}
			BeanUtils.copyProperties(object, tmp);
			tx.commit();
			flat = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return flat;
	}

	public <T> boolean deleteByPK(Class<T> classname, Object key) {
		// TODO Auto-generated method stub
		boolean flat = false;
		PersistenceManager pm = persistenceManagerFactory.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object tmp = pm.getObjectById(classname, key);
			if (tmp == null) {
				return false;
			}
			pm.deletePersistent(tmp);
			tx.commit();
			flat = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return flat;
	}

}
