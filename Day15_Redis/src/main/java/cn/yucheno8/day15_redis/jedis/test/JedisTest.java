package cn.yucheno8.day15_redis.jedis.test;

import cn.yucheno8.day15_redis.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test() {
        // 1.获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        // 2.操作
        jedis.set("username", "zhangsan");
        // 3.关闭连接
        jedis.close();
    }

    /**
     * String 数据结构操作
     */
    @Test
    public void test2() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        //存储
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode",20,"hehe");//将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对

        // 3.关闭连接
        jedis.close();
    }

    /**
     * Hash 数据结构操作
     */
    @Test
    public void test3() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        // 存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");

        // 获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        // 获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");

        // keySet遍历集合
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            // 获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }

        // 3.关闭连接
        jedis.close();
    }

    /**
     * List 数据结构操作
     */
    @Test
    public void test4() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        // list 存储
        jedis.lpush("mylist", "a", "b", "c"); // 从左边存
        jedis.rpush("mylist", "a", "b", "c"); // 从右边存

        // list 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String element = jedis.lpop("mylist"); // c
        System.out.println(element);

        String element2 = jedis.rpop("mylist"); // c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);

        // 3.关闭连接
        jedis.close();
    }

    /**
     * Set 数据结构操作
     */
    @Test
    public void test5() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        // set 存储
        jedis.sadd("myset", "java", "php", "c++");

        // set 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        // 3.关闭连接
        jedis.close();
    }

    /**
     * Sortedset 数据结构操作
     */
    @Test
    public void test6() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2.操作
        // sortedset 存储
        jedis.zadd("mySortedset", 3, "亚瑟");
        jedis.zadd("mySortedset", 30, "后裔");
        jedis.zadd("mySortedset", 25, "孙悟空");

        // Sortedset 获取
        Set<String> mySortedset = jedis.zrange("mySortedset", 0, -1);
        System.out.println(mySortedset);


        // 3.关闭连接
        jedis.close();
    }

    /**
     * jedis连接池使用
     */
    @Test
    public void test7() {

        // 0.创建JedisPoolConfig
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);

        // 1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        // 2.获取连接
        Jedis jedis = jedisPool.getResource();

        // 3.使用
        jedis.set("hehe", "heihei");

        // 4.关闭 归还到连接池中
        jedis.close();
    }

    /**
     * jedis连接池工具类使用
     */
    @Test
    public void test8() {

        // 通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        // 3.使用
        jedis.set("hello", "world");

        // 4.关闭 归还到连接池中
        jedis.close();
    }



}
