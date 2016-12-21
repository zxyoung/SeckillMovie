package com.zhang.movie.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zhang.movie.Dao.SeckillDetailDao;
import com.zhang.movie.Model.SeckillDetail;
import com.zhang.movie.Utils.JDOUtil;

@Repository
public class SeckillDetailImpl implements SeckillDetailDao {

	@Autowired
	@Qualifier("JDOUtilImpl")
	private JDOUtil jdoUtil;

	public int insert(SeckillDetail seckillDetail) {
		// TODO Auto-generated method stub
		return (Integer) jdoUtil.insert(seckillDetail);
	}

	public boolean update(SeckillDetail seckillDetail) {
		// TODO Auto-generated method stub
		return jdoUtil.update(seckillDetail);
	}

	public SeckillDetail selectByUserAndMovieId(int user_id, int movie_id) {
		// TODO Auto-generated method stub
		String sql = "user_id==" + user_id + " && movie_id==" + movie_id;
		return (SeckillDetail) jdoUtil.selectByQuery(SeckillDetail.class, sql);
	}

	public SeckillDetail selectById(int id) {
		// TODO Auto-generated method stub
		return jdoUtil.selectByPK(SeckillDetail.class, id);
	}

	public List<SeckillDetail> selectByUserId(int user_id) {
		// TODO Auto-generated method stub
		String sql = "user_id==" + user_id;
		return jdoUtil.selectByQuery(SeckillDetail.class, sql);
	}

	public List<SeckillDetail> selectByMovieId(int movie_id) {
		// TODO Auto-generated method stub
		String sql = "movie_id==" + movie_id;
		return jdoUtil.selectByQuery(SeckillDetail.class, sql);
	}

}
