package com.zhang.movie.Model;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table = "movie")
public class Movie {
	/**
	 * 电影id
	 */
	@PrimaryKey
	@Column(name = "id")
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int id;

	
	/**
	 * 电影名字
	 */
	@Column(name = "movie_name")
	private String name;

	/**
	 * 电影剩余票数
	 */
	@Column(name = "rest_num")
	private int rest_num;

	

	/**
	 * 添加时间
	 */
	@Column(name = "add_time")
	private Date addTime;

	/**
	 * 开始时间
	 */
	@Column(name = "start_time")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@Column(name = "end_time")
	private Date endTime;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return rest_num;
	}

	public void setNumber(int rest_num) {
		this.rest_num = rest_num;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", rest_num=" + rest_num + ", addTime=" + addTime + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

	
	
}
