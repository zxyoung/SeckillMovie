package com.zhang.movie.Controller;

import java.util.List;

import javax.jws.WebParam.Mode;

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
import com.zhang.movie.dto.SeckillResult;

@Controller
@RequestMapping("/seckill") // url: /模块/资源/{id}/细分
public class SeckillController {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeckillService seckillService;

	@RequestMapping(name = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Movie> list = seckillService.getAllMovieList();
		model.addAttribute("list", list);
		return "list";
	}

	/**
	 * 取得电影票信息
	 * 
	 * @param model
	 * @param movie_id
	 * @return
	 */
	@RequestMapping(value="/{movie_id}/detail", method = RequestMethod.GET)
	public String getMovieDetail(Model model, @PathVariable("movie_id") Integer movie_id) {
		if (movie_id == null) {
			return "redirect:/seckill/list";
		}
		try {
			MovieDto movieDto = seckillService.getMovieDetailsById(movie_id);
			if (movieDto.getMovie() == null) {
				throw new RuntimeException("电影票不存在！");
			}
			Movie movie = movieDto.getMovie();
			model.addAttribute("movie", movie);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
		}
		return "movie_detail";
	}

	@RequestMapping("/movieMd5/{movieId}")
	@ResponseBody
	public SeckillResult getMovieMD5(Model model, Integer movie_id){
		logger.debug("enter into getMovieTickeMd5 movieId=" + movie_id);
		SeckillResult seckillResult = new SeckillResult();
		
		MovieDto movieDto = seckillService.getMovieDetailsById(movie_id);
		if(movieDto == null){
			throw new RuntimeException("此票出现错误！");
		}
		seckillResult.setData(movieDto);
		seckillResult.setSuccess(true);
		return seckillResult;
	}
	
}
