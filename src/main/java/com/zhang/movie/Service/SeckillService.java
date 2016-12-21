package com.zhang.movie.Service;

import java.util.List;

import com.zhang.movie.Model.Movie;
import com.zhang.movie.dto.MovieDto;
import com.zhang.movie.dto.SeckillDto;

public interface SeckillService {
	/**
	 * ���������Ʊ����
	 * 
	 * @return
	 */
	List<Movie> getAllMovie();

	/**
	 * ��õ�ӰƱ��Ϣ
	 * 
	 * @param id
	 *            ��Ӱid
	 * @return
	 */
	MovieDto getMovieDetailsById(int id);

	/**
	 * ��õ�Ӱ����Ʊ����
	 * 
	 * @param id
	 *            ��Ӱid
	 * @return
	 */
	int getRestNumber(int id);

	/**
	 * �����=>��Ӽ�¼
	 * 
	 * @param user_id
	 *            �û�id
	 * @param email
	 *            �û���email
	 * @param movie_id
	 *            ��Ӱid
	 * @param md5
	 *            ��֤��
	 * @return
	 */
	SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5);

	/**
	 * �����=>��Ӽ�¼
	 * 
	 * @param user_id
	 *            �û�id
	 * @param email
	 *            �û���email
	 * @param movie_id
	 *            ��Ӱid
	 * @param md5
	 *            ��֤��
	 * @param number
	 *            ��Ʊ����
	 * @return
	 */
	SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5, int number);
}
