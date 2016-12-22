package com.zhang.movie.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zhang.movie.Dao.MovieDao;
import com.zhang.movie.Model.Movie;
import com.zhang.movie.Utils.JDOUtil;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	@Qualifier("JDOUtilImpl")
	private JDOUtil jdoUtil;

	public int insert(Movie movie) {
		return (Integer) jdoUtil.insert(movie);
	}

	public List<Movie> getAllList() {
		@SuppressWarnings("unchecked")
		List<Movie> list = (List<Movie>) jdoUtil.selectByPK(Movie.class, "");
		return list;
	}

	public Movie getMovieById(int m_id) {
		return jdoUtil.selectByPK(Movie.class, m_id);
	}

	public boolean update(Movie movie) {
		return jdoUtil.update(movie);
	}

	public int getTicketNumber(int m_id) {
		Movie tmp = jdoUtil.selectByPK(Movie.class, m_id);
		if (tmp != null) {
			return tmp.getNumber();
		}
		return 0;
	}

}
