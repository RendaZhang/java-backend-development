package cn.renda.jedis.test;

import cn.renda.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Renda Zhang
 * @create 2020-04-25 18:44
 */
public class JedisTest {

    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.set("username", "zhangsan");

        jedis.close();
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis();

        jedis.set("username", "zhangsan");
        System.out.println(jedis.get("username"));

        jedis.close();
    }

    @Test
    public void test3() {
        Jedis jedis = new Jedis();

        jedis.hset("user","name", "lisi");
        jedis.hset("user","age", "24");
        jedis.hset("user","gender", "male");

        System.out.println(jedis.hget("user", "name"));

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for(String key : keySet) {
            System.out.println(key+" : "+user.get(key));
        }

        jedis.close();
    }

    @Test
    public void test4() {
        Jedis jedis = new Jedis();

        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "a", "b", "c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        jedis.close();
    }

    @Test
    public void test5() {
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello", "world");
        System.out.println(jedis.get("hello"));

        jedis.close();
    }
}
