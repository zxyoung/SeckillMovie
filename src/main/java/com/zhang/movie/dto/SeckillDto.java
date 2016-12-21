package com.zhang.movie.dto;

import com.zhang.movie.Model.SeckillDetail;

/**
 * ��ɱ��Ϣ
 * 
 * @author Administrator
 *
 */
public class SeckillDto {
	/**
	 * ��Ʊ״̬
	 */
	private boolean status;
	
	/**
	 * ������Ϣ
	 */
	private String message;
	private String state;
	private SeckillDetail seckillDetail;

	//��Ʊ���
	public SeckillDto(SeckillResultEnum seckillResultEnum) {
		this.message = seckillResultEnum.value();
		this.state = seckillResultEnum.toString();
		if (seckillResultEnum == SeckillResultEnum.SECKILL_SUCCESS)
			this.status = true;
		else
			this.status = false;
	}
	//��Ʊ���
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
