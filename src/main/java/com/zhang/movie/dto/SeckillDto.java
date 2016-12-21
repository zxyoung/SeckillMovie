package com.zhang.movie.dto;

import com.zhang.movie.Model.SeckillDetail;

/**
 * 秒杀信息
 * 
 * @author Administrator
 *
 */
public class SeckillDto {
	/**
	 * 抢票状态
	 */
	private boolean status;
	
	/**
	 * 抢购信息
	 */
	private String message;
	private String state;
	private SeckillDetail seckillDetail;

	//抢票结果
	public SeckillDto(SeckillResultEnum seckillResultEnum) {
		this.message = seckillResultEnum.value();
		this.state = seckillResultEnum.toString();
		if (seckillResultEnum == SeckillResultEnum.SECKILL_SUCCESS)
			this.status = true;
		else
			this.status = false;
	}
	//抢票结果
	public SeckillDto(SeckillResultEnum seckillResultEnum, SeckillDetail seckillDetail) {
		this(seckillResultEnum);
		this.seckillDetail = seckillDetail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SeckillDetail getSeckillDetail() {
		return seckillDetail;
	}

	public void setSeckillDetail(SeckillDetail seckillDetail) {
		this.seckillDetail = seckillDetail;
	}

	
	
}
