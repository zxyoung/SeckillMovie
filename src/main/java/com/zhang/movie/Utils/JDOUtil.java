package com.zhang.movie.Utils;

import java.util.List;

public interface JDOUtil {
	/**
	 * ����������ȡ����
	 * @param classname ʵ����
	 * @param obj ����
	 * @return �鵽�ļ�¼
	 */
	<T> T selectByPK(Class<T> classname, Object obj);
	
	/**
	 * ����sql������������ѯ��¼
	 * @param var ʵ����
	 * @param query ��������
	 * @return �鵽�ļ�¼
	 */
	<T> List<T> selectByQuery(Class<T> classname, String sql);
	
	/**
	 * ����һ������
	 * @param object
	 * @return 
	 */
	<T> Object insert(T object);
	
	
	/**
	 * ��������
	 * @param object
	 * @return yes or no
	 */
	<T> boolean update(T object);
	
	/**
	 * ɾ������
	 * @param var ʵ����
	 * @param key ����
	 * @return yes or no
	 */
	<T> boolean deleteByPK(Class<T> var, Object key);
}
