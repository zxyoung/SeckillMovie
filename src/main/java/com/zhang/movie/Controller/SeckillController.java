package com.zhang.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.movie.Model.Movie;
import com.zhang.movie.Service.SeckillService;
import com.zhang.movie.dto.MovieDto;

import sun.util.logging.resources.logging;

@Controller
public class SeckillController {
	
	@Autowired
	SeckillService seckillService;
	
	@RequestMapping()
	@ResponseBody
	public List<Movie> getAllMovie(){
		return seckillService.getAllMovie();
	}
	
	
	/**
	 * 取得电影票信息
	 * @param model
	 * @param movie_id
	 * @return
	 */
	public String getMovie(Model model, int movie_id){
		try {
			MovieDto movieDto = seckillService.getMovieDetailsById(movie_id);
			if(movieDto.getMovie()==null){
				throw new RuntimeException("电影票不存在！");
			}
			model.addAttribute("movie", movieDto.getMovie());
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			e.printStackTrace();
		}

		return "movie_detail";
	}
	
}
