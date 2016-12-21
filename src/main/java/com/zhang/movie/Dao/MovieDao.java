package com.zhang.movie.Dao;

import java.util.List;

import com.zhang.movie.Model.Movie;

public interface MovieDao {
	
	/**
	 * 增加一部新电影
	 * @param movie
	 * @return
	 */
	int insert(Movie movie);
	
	/**
	 * 获得所有电影
	 * @return
	 */
	List<Movie> getAllList();
	
	/**
	 * 根据id获得电影
	 * @param m_id
	 * @return
	 */
	Movie getMovieById(int m_id);
	
	/**
	 * 更新一部电影信息
	 * @param movie
	 * @return
	 */
	boolean update(Movie movie);
	
	/**
	 * 获得相应id号电影的余票
	 * @param id
	 * @return
	 */
	int getTicketNumber(int m_id);
}
