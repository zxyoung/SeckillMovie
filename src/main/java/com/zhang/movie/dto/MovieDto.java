package com.zhang.movie.dto;

import java.util.Date;

import com.zhang.movie.Model.Movie;

public class MovieDto {
	
	private Movie movie;
	
	private String md5;

	private Date now;
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}
	
}
