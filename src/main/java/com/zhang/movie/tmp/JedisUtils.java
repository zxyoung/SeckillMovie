package com.zhang.movie.tmp;

import redis.clients.jedis.Jedis;

public class JedisUtils {
	private static Jedis jedis = new Jedis("localhost");
	
	public static Jedis getJedisInstance(){
		return jedis;
	}
}
