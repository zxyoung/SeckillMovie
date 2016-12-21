package com.zhang.movie.Dao;

import java.util.List;

import com.zhang.movie.Model.SeckillDetail;

public interface SeckillDetailDao {
	
	/**
	 * ����һ����Ʊ��¼
	 * @param seckillDetail
	 * @return
	 */
	int insert(SeckillDetail seckillDetail);
	
	/**
	 * ����һ����Ʊ��¼
	 * @param seckillDetail
	 * @return
	 */
	boolean update(SeckillDetail seckillDetail);
	
	/**
	 * �����û�id�͵�Ӱid��������������һ����Ʊ��¼
	 * @param user_id
	 * @param movie_id
	 * @return
	 */
	SeckillDetail selectByUserAndMovieId(int user_id, int movie_id);
	
	/**
	 * ���ݶ���id������Ʊ��¼
	 * @param id
	 * @return
	 */
	SeckillDetail selectById(int id);
	
	/**
	 * �����û�id��ѯ���ж���
	 * @param user_id
	 * @return
	 */
	List<SeckillDetail> selectByUserId(int user_id);

	/**
	 * ���ݵ�Ӱid��ѯ���ж���
	 * @param movie_id
	 * @return
	 */
	List<SeckillDetail> selectByMovieId(int movie_id);
}
