package com.ufo.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * projectName: jedis
 * author:小黄同学
 * time: 2020/9/24 14:15
 * description:
 */
public class JedisTest {
    @Test
    public void test(){
        //连上redis数据库
        Jedis jedis = new Jedis("47.99.223.210",6379);
        jedis.set("username","jack");
        String username = jedis.get("username");
        System.out.println("username = " + username);
    }
    @Test
    public void test1() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(50);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"47.99.223.210",6379);
        Jedis jedis = jedisPool.getResource();
        User user = new User(1001,"zhangsan");
        jedis.set("user", JSON.toJSONString(user));
        System.out.println(jedis.get("user"));


    }
}
