package com.zhang.Test;

import com.zhang.movie.tmp.JedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class FirstClient {

	Jedis jedis = JedisUtils.getJedisInstance();

	public void testConn() {
		try {
			jedis.connect();
			jedis.ping();
			jedis.quit();
		} catch (JedisConnectionException e) {
			e.printStackTrace();
		}
	}

	public void setTest() {
		try {
			for (int i = 0; i < 100; i++) {
				jedis.set("key" + i, "value" + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getTest() {
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(jedis.get("key" + i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FirstClient client = new FirstClient();
//		client.setTest();
		client.getTest();
	}
}
