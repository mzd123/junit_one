import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/11.
 */
public class Redis_java {
    @Test
    public void doT() {
        //连接本地的Redis服务=====前提是本地的Redis是开着的（cmd---切换目录到安装redis的文件夹---redis-server.exe redis.windows.conf ---redis服务启动了）
        Jedis jedis = new Jedis("localhost");
        //ping()方法用于判断服务是否运行====如果输出为PONG就说明本地Redis已经启动了
        System.out.println(jedis.ping());
        //========================字符串=============================
        System.out.println("=======================字符串=============================");
        //键值对的形式存在，其中zei6表示key，马周狄表示value值。====set赋值，get取值
        jedis.set("zei6", "马周狄");
        System.out.println(jedis.get("zei6"));
        //=======================链表List=============================
        System.out.println("=======================链表List=============================");
        //用lpush方法将数据存到链表list中
        jedis.lpush("key", "mzd1");
        jedis.lpush("key", "mzd2");
        jedis.lpush("key", "mzd3");
        jedis.lpush("key", "mzd4");
        List<String> list = jedis.lrange("key", 0, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //=======================keys实例=============================
        System.out.println("=======================keys实例=============================");
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }
    }
}
