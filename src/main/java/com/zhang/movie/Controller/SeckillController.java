package com.zhang.movie.Controller;

import java.util.List;

import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.movie.Model.Movie;
import com.zhang.movie.Service.SeckillService;
import com.zhang.movie.dto.MovieDto;
import com.zhang.movie.dto.SeckillDto;
import com.zhang.movie.dto.SeckillResult;

@Controller
@RequestMapping("/seckill") // url: /ģ��/��Դ/{id}/ϸ��
public class SeckillController {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeckillService seckillService;

	/**
	 * ��ȡ���е�Ӱ���б�
	 * @param model
	 * @return
	 */
	@RequestMapping(name = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Movie> list = seckillService.getAllMovieList();
		model.addAttribute("list", list);
		return "list";
	}

	/**
	 * ȡ�õ�ӰƱ��ϸ��Ϣ
	 * 
	 * @param model
	 * @param movie_id
	 * @return
	 */
	@RequestMapping(value = "/{movie_id}/detail", method = RequestMethod.GET)
	public String getMovieDetail(Model model, @PathVariable("movie_id") Integer movie_id) {
		if (movie_id == null) {
			return "redirect:/seckill/list";
		}
		try {
			MovieDto movieDto = seckillService.getMovieDetailsById(movie_id);
			if (movieDto.getMovie() == null) {
				throw new RuntimeException("��ӰƱ�����ڣ�");
			}
			Movie movie = movieDto.getMovie();
			model.addAttribute("movie", movie);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
		}
		return "movie_detail";
	}

	/**
	 * ��ȡ��Ӱ��MD5��ֵ
	 * @param model
	 * @param movie_id
	 * @return
	 */
	@RequestMapping(value = "/movieMd5/{movieId}", method = RequestMethod.POST)
	@ResponseBody
	public SeckillResult getMovieMD5(Model model, Integer movie_id) {
		logger.debug("enter into getMovieTickeMd5 movieId=" + movie_id);
		SeckillResult seckillResult = new SeckillResult();

		try {
			MovieDto movieDto = seckillService.getMovieDetailsById(movie_id);
			seckillResult.setData(movieDto);
		} catch (Exception e) {
			seckillResult.setSuccess(false);
			seckillResult.setError(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return seckillResult;
	}

	/**
	 * �����Ʊ�Ľ��
	 * @param movie_id
	 * @param md5
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/seckill/{movie_id}/{md5}")
	public SeckillResult seckillMovieTicket(@PathVariable Integer movie_id, @PathVariable String md5,
			HttpSession session) {
		logger.debug("��Ӱ��id�� ��" + movie_id + "��md5��ֵ�ǣ�" + md5);
		SeckillResult seckillResult = new SeckillResult();

		Integer user_id = (Integer) session.getAttribute("user_id");
		String email = (String) session.getAttribute("email");
		if (user_id == null || email == null) {
			logger.debug("δ��䛣�");
			session.removeAttribute("user_id");
			session.removeAttribute("email");

			seckillResult.setSuccess(false);
			seckillResult.setError("��δ��¼��");
			seckillResult.setData("���¼��");
			return seckillResult;
		}

		try {
			SeckillDto seckillMovie = seckillService.seckillMovie(user_id, email, movie_id, md5);
			seckillResult.setData(seckillMovie);
		} catch (Exception e) {
			seckillResult.setSuccess(false);
			seckillResult.setError(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return seckillResult;
	}

	
	/**
	 * ���ص�Ӱ��Ʊ���
	 * @param movie_id
	 * @return
	 */
	@RequestMapping("/movieNumer/{movie_id}")
	@ResponseBody
	public SeckillResult getRestTicketNumber(@PathVariable Integer movie_id) {
		logger.debug("getRestTicketNumber movie_id=" + movie_id);
		SeckillResult seckillResult = new SeckillResult();
		
		try {
			int rest_number = seckillService.getRestNumber(movie_id);
			seckillResult.setData(rest_number);
		} catch (Exception e) {
			seckillResult.setSuccess(false);
			seckillResult.setError(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return seckillResult;
	}

}
