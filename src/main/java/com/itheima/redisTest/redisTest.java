package com.itheima.redisTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class redisTest {
    private Jedis jedis;
    @Test
    //jedis的入门代码
    public void jedisone(){
        //创建jedis对象
         jedis = new Jedis("192.168.56.102", 6379);
        //测试一下是否联通
        String ping = jedis.ping();
        //打印出来pong为已经联通
        System.out.println(ping);
        //释放资源
        jedis.close();
    }
    //redis-->  String
    public void redisString(){
        //创建jedis对象
        jedis = new Jedis("192.168.56.102", 6379);
        //向redis中存值
        jedis.set("name","啦啦啦");
        jedis.set("age","16");
        //从redis中取值
        String name = jedis.get("name");
        System.out.println(name);
        //删除值
        //jedis.del("name");
        //对age进行+1操作
        Long age = jedis.incr("age");
        System.out.println(age);
        //对age进行-1操作
        Long age1 = jedis.decr("age");
        System.out.println(age1);
        //拼接字符串: 如果key存在就是拼接, 如果不存在就会重新创建
        jedis.append("hobby", "蹦迪");
        String hobby = jedis.get("hobby");
        System.out.println(hobby);

        //为key设置有效的时长

    }
}
