package com.zhang.movie.Dao;

import java.util.List;

import com.zhang.movie.Model.SeckillDetail;

public interface SeckillDetailDao {
	
	/**
	 * 新增一条抢票记录
	 * @param seckillDetail
	 * @return
	 */
	int insert(SeckillDetail seckillDetail);
	
	/**
	 * 更新一条抢票记录
	 * @param seckillDetail
	 * @return
	 */
	boolean update(SeckillDetail seckillDetail);
	
	/**
	 * 根据用户id和电影id两个限制来查找一个抢票记录
	 * @param user_id
	 * @param movie_id
	 * @return
	 */
	SeckillDetail selectByUserAndMovieId(int user_id, int movie_id);
	
	/**
	 * 根据订单id查找抢票记录
	 * @param id
	 * @return
	 */
	SeckillDetail selectById(int id);
	
	/**
	 * 根据用户id查询所有订单
	 * @param user_id
	 * @return
	 */
	List<SeckillDetail> selectByUserId(int user_id);

	/**
	 * 根据电影id查询所有订单
	 * @param movie_id
	 * @return
	 */
	List<SeckillDetail> selectByMovieId(int movie_id);
}
