package com.zhang.movie.dto;

public enum SeckillResultEnum {
	SECKILL_FAIL(-2, "��Ʊʧ�ܣ�"), 
	REPEAT_SECKILL(-1, "��Ʊ���㣡"), 
	SECKILL_ERROR(0, "���ִ���"), 
	SECKILL_SUCCESS(1, "�����ɹ���"),
	MD5_ERROR(2, "��ӰƱУ�����"), 
	SECKILL_NOT_BEGIN(3, "��Ʊδ��ʼ��"), 
	SECKILL_HAVE_CLOSED(4, "��Ʊ�ѽ�����");

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
