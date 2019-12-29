package com.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Brian in 21:12 2018/4/6
 */
public class Test {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost", 6379);
        System.out.println(redis.ping());
        testStr(redis);
        redis.close();
    }

    public static void testStr(Jedis redis) {
        redis.set("Test", "hello");
        String str =  redis.get("Test");
        System.out.println(str);
    }
}
