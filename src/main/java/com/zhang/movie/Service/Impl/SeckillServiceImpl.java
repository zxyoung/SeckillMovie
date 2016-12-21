package com.zhang.movie.Service.Impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhang.movie.Dao.MovieDao;
import com.zhang.movie.Dao.SeckillDetailDao;
import com.zhang.movie.Model.Movie;
import com.zhang.movie.Model.SeckillDetail;
import com.zhang.movie.Service.MailService;
import com.zhang.movie.Service.SeckillService;
import com.zhang.movie.dto.MovieDto;
import com.zhang.movie.dto.SeckillDto;
import com.zhang.movie.dto.SeckillResultEnum;

@Service
public class SeckillServiceImpl implements SeckillService {

	@Autowired
	private MailService mailService;

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private SeckillDetailDao seckillDetailDao;

	@Autowired
	private Logger log;

	public List<Movie> getAllMovie() {
		return movieDao.getAllList();
	}

	public MovieDto getMovieDetailsById(int id) {

		MovieDto movieDto = new MovieDto();
		Movie movie = movieDao.getMovieById(id);
		movieDto.setMovie(movie);
		if (movie != null) {
			Date now = new Date();
			movieDto.setNow(now);
			if (movie.getStartTime().before(now) && movie.getEndTime().after(now)) {
				movieDto.setMd5(getMovieMd5(id));
			}
		}
		return movieDto;
	}

	private String getMovieMd5(int id) {
		String slat = "asfdsal;ifjoi32jflksfsal^sakjhfr";
		String tmp = slat + id;
		return DigestUtils.md5DigestAsHex(tmp.getBytes());
	}

	/**
	 * 获得余票数量
	 */
	public int getRestNumber(int id) {
		return movieDao.getTicketNumber(id);
	}

	public SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5) {
		return seckillMovie(user_id, email, movie_id, md5, 1);
	}

	public SeckillDto seckillMovie(int user_id, String email, int movie_id, String md5, int number) {
		log.debug("电影id是：" + movie_id + " 用户id是：" + user_id);
		if (user_id < 0 || movie_id < 0) {
			log.debug("id有错误！");
			return new SeckillDto(SeckillResultEnum.SECKILL_ERROR);
		}
		if (md5 == null || !md5.equals(getMovieMd5(movie_id))) {
			log.debug("校验码有错误！");
			return new SeckillDto(SeckillResultEnum.MD5_ERROR);
		}
		if (movieDao.getMovieById(movie_id) == null) {
			log.debug("不存在该电影！");
			return new SeckillDto(SeckillResultEnum.SECKILL_FAIL);
		}
		Date now = new Date();
		if (movieDao.getMovieById(movie_id).getEndTime().before(now)) {
			log.debug("已经结束！");
			return new SeckillDto(SeckillResultEnum.SECKILL_HAVE_CLOSED);
		} else if (movieDao.getMovieById(movie_id).getStartTime().after(now)) {
			log.debug("还未开始！");
			return new SeckillDto(SeckillResultEnum.SECKILL_NOT_BEGIN);
		}

		SeckillDetail seckillDetail = seckillDetailDao.selectByUserAndMovieId(user_id, movie_id);
		if (seckillDetail != null) {
			log.debug("重复抢票！！");
			return new SeckillDto(SeckillResultEnum.REPEAT_SECKILL);
		}
		
		//TO-DO
		return null;
	}

}
