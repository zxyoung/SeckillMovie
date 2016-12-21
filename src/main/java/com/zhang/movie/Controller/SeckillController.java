package com.zhang.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.movie.Model.Movie;
import com.zhang.movie.Service.SeckillService;

@Controller
public class SeckillController {
	
	@Autowired
	SeckillService seckillService;
	
	@RequestMapping()
	@ResponseBody
	public List<Movie> getAllMovie(){
		return seckillService.getAllMovie();
	}
	
	
}
