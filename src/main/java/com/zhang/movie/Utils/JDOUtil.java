package com.zhang.movie.Utils;

import java.util.List;

public interface JDOUtil {
	/**
	 * 根据主键获取数据
	 * @param classname 实体类
	 * @param obj 主键
	 * @return 查到的记录
	 */
	<T> T selectByPK(Class<T> classname, Object obj);
	
	/**
	 * 根据sql的限制条件查询记录
	 * @param var 实体类
	 * @param query 限制条件
	 * @return 查到的记录
	 */
	<T> List<T> selectByQuery(Class<T> classname, String sql);
	
	/**
	 * 新增一个对象
	 * @param object
	 * @return 
	 */
	<T> Object insert(T object);
	
	
	/**
	 * 更新数据
	 * @param object
	 * @return yes or no
	 */
	<T> boolean update(T object);
	
	/**
	 * 删除数据
	 * @param var 实体类
	 * @param key 主键
	 * @return yes or no
	 */
	<T> boolean deleteByPK(Class<T> var, Object key);
}
