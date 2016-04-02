package com.my.test.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisExample{
	private ShardedJedisPool pool;

	
	public String test(String keyRedis) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
		pool = (ShardedJedisPool)context.getBean("shardedJedisPool");
		// 从池中获取一个Jedis对象
		ShardedJedis jedis = pool.getResource();
		String keys = keyRedis;
		String value = "snowolfdddwsy";
		// 删数据
		if(jedis.get(keys) == null){
		      // 存数据
	        jedis.set(keys, value);
		}
		// 取数据
		String v = jedis.get(keys);

		System.out.println(v);

		// 释放对象池
		pool.returnResource(jedis);
		return v;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new RedisExample().test("ddmap");
		// 1.初始化
		/*Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("192.168.115.10:6379");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids连接成功...");

		// 2.测试concurrentMap,put方法的时候就会同步到redis中
		ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
		map.put("wuguowei", "男");
		map.put("zhangsan", "nan");
		map.put("lisi", "女");

		ConcurrentMap resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());

		// 2.测试Set集合
		Set mySet = redisson.getSet("MySet");
		mySet.add("wuguowei");
		mySet.add("lisi");

		Set resultSet = redisson.getSet("MySet");
		System.out.println("resultSet===" + resultSet.size());
		
		//3.测试Queue队列
		Queue myQueue = redisson.getQueue("FirstQueue");
		myQueue.add("wuguowei");
		myQueue.add("lili");
		myQueue.add("zhangsan");
		myQueue.peek();
		myQueue.poll();

		Queue resultQueue=redisson.getQueue("FirstQueue");
		System.out.println("resultQueue==="+resultQueue);
		
		// 关闭连接
		redisson.shutdown();*/
	}

}
