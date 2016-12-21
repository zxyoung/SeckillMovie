package com.zhang.movie.Model;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table="seckill_detail")
public class SeckillDetail {
	
	/**
	 * ����id
	 */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private int id;

    /**
     * �û�id
     */
    @Column(name="user_id")
    private int user_id;

    /**
     * ��Ӱid
     */
    @Column(name = "movie_id")
    private int movie_id;

    /**
     * ����
     */
    @Column(name="number")
    private int number;

    /**
     * ����ʱ��
     */
    @Column(name = "seckill_time", allowsNull = "false")
    private Date snapTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return user_id;
	}

	public void setUserid(int user_id) {
		this.user_id = user_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getSnapTime() {
		return snapTime;
	}

	public void setSnapTime(Date snapTime) {
		this.snapTime = snapTime;
	}

	@Override
	public String toString() {
		return "SeckillDetail [id=" + id + ", userid=" + user_id + ", movie_id=" + movie_id + ", number=" + number
				+ ", snapTime=" + snapTime + "]";
	}
	
    
	
}
