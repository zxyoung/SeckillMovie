package com.zhang.movie.dto;

public enum SeckillResultEnum {
	SECKILL_FAIL(-2, "抢票失败！"), 
	REPEAT_SECKILL(-1, "余票不足！"), 
	SECKILL_ERROR(0, "出现错误！"), 
	SECKILL_SUCCESS(1, "抢购成功！"),
	MD5_ERROR(2, "电影票校验错误！"), 
	SECKILL_NOT_BEGIN(3, "抢票未开始！"), 
	SECKILL_HAVE_CLOSED(4, "抢票已结束！");

	private int key;
	private String val;

	private SeckillResultEnum(int key, String val) {
		this.key = key;
		this.val = val;
	}

	public String value() {
		return val;
	}

	public int key() {
		return key;
	}

	public static SeckillResultEnum getState(int state) {
		for (SeckillResultEnum seckillResultEnum : SeckillResultEnum.values()) {
			if (state == seckillResultEnum.key()) {
				return seckillResultEnum;
			}
		}
		return null;

	}

}
