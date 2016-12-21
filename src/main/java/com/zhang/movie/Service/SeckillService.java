package com.zhang.movie.Service;

import java.util.List;

import com.zhang.movie.Model.Movie;
import com.zhang.movie.dto.MovieDto;
import com.zhang.movie.dto.SeckillDto;

public interface SeckillService {
	/**
	 * 获得所有抢票订单
	 * 
	 * @return
	 */
	List<Movie> getAllMovie();

	/**
	 * 获得电影票信息
	 * 
	 * @param id
	 *            电影id
	 * @return
	 */
	MovieDto getMovieDetailsById(int id);

	/**
	 * 获得电影的余票数量
	 * 
	 * @param id
	 *            电影id
	 * @return
	 */
	int getRestNumber(int id);

	/**
	 * 减库存=>添加记录
	 * 
	 * @param user_id
	 *            用户id
	 * @param email
	 *            用户的email
	 * @param movie_id
	 *            电影id
	 * @param md5
	 *            验证码
	 * @return
	 */
	SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5);

	/**
	 * 减库存=>添加记录
	 * 
	 * @param user_id
	 *            用户id
	 * @param email
	 *            用户的email
	 * @param movie_id
	 *            电影id
	 * @param md5
	 *            验证码
	 * @param number
	 *            抢票数量
	 * @return
	 */
	SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5, int number);
}
