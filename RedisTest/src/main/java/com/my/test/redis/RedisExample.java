package com.my.test.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisExample{
	private ShardedJedisPool pool;

	
	public String test(String keyRedis) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring.xml" });
		pool = (ShardedJedisPool)context.getBean("shardedJedisPool");
		// �ӳ��л�ȡһ��Jedis����
		ShardedJedis jedis = pool.getResource();
		String keys = keyRedis;
		String value = "snowolfdddwsy";
		// ɾ����
		if(jedis.get(keys) == null){
		      // ������
	        jedis.set(keys, value);
		}
		// ȡ����
		String v = jedis.get(keys);

		System.out.println(v);

		// �ͷŶ����
		pool.returnResource(jedis);
		return v;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new RedisExample().test("ddmap");
		// 1.��ʼ��
		/*Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("192.168.115.10:6379");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids���ӳɹ�...");

		// 2.����concurrentMap,put������ʱ��ͻ�ͬ����redis��
		ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
		map.put("wuguowei", "��");
		map.put("zhangsan", "nan");
		map.put("lisi", "Ů");

		ConcurrentMap resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());

		// 2.����Set����
		Set mySet = redisson.getSet("MySet");
		mySet.add("wuguowei");
		mySet.add("lisi");

		Set resultSet = redisson.getSet("MySet");
		System.out.println("resultSet===" + resultSet.size());
		
		//3.����Queue����
		Queue myQueue = redisson.getQueue("FirstQueue");
		myQueue.add("wuguowei");
		myQueue.add("lili");
		myQueue.add("zhangsan");
		myQueue.peek();
		myQueue.poll();

		Queue resultQueue=redisson.getQueue("FirstQueue");
		System.out.println("resultQueue==="+resultQueue);
		
		// �ر�����
		redisson.shutdown();*/
	}

}
