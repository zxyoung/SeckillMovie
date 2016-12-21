package com.zhang.movie.Dao;

import java.util.List;

import com.zhang.movie.Model.Movie;

public interface MovieDao {
	
	/**
	 * ����һ���µ�Ӱ
	 * @param movie
	 * @return
	 */
	int insert(Movie movie);
	
	/**
	 * ������е�Ӱ
	 * @return
	 */
	List<Movie> getAllList();
	
	/**
	 * ����id��õ�Ӱ
	 * @param m_id
	 * @return
	 */
	Movie getMovieById(int m_id);
	
	/**
	 * ����һ����Ӱ��Ϣ
	 * @param movie
	 * @return
	 */
	boolean update(Movie movie);
	
	/**
	 * �����Ӧid�ŵ�Ӱ����Ʊ
	 * @param id
	 * @return
	 */
	int getTicketNumber(int m_id);
}
