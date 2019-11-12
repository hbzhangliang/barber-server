package cn.com.cube.platform.barber.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConf {
    @Value("${spring.jedis.pool.max-active}")
    private int redisPoolMaxActive;
    @Value("${spring.jedis.pool.max-idle}")
    private int redisPoolMaxIdle;
    @Value("${spring.jedis.pool.min-idle}")
    private int redisPoolMinIdle;

    @Value("${spring.redis.host}")
    private String redis1_host;
    @Value("${spring.redis.port}")
    private int redis1_port;
    @Value("${spring.redis.password}")
    private String redis1_password;
    @Value("${spring.redis.database}")
    private int redis1_database;


    @Value("${spring.redis-two.host}")
    private String redis2_host;
    @Value("${spring.redis-two.port}")
    private int redis2_port;
    @Value("${spring.redis-two.password}")
    private String redis2_password;
    @Value("${spring.redis-two.database}")
    private int redis2_database;


    public RedisConnectionFactory redisConnectionFactory(String host, Integer port, String password, int index) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setDatabase(index);
        jedisConnectionFactory.setPoolConfig(setPoolConfig(redisPoolMaxIdle, redisPoolMinIdle, redisPoolMaxActive));
        return jedisConnectionFactory;
    }

    @Primary
    @Bean
    public RedisConnectionFactory primaryRedisConnectionFactory() {
        return redisConnectionFactory(redis1_host, redis1_port, redis1_password, redis1_database);
    }

    @Bean
    public RedisConnectionFactory defaultRedisConnectionFactory() {
        return redisConnectionFactory(redis2_host, redis2_port, redis2_password,redis2_database);
    }

    @Bean(name = "redisOneTemplate")
    public RedisTemplate redisOneTemplate() {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(primaryRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

//    @Bean(name = "stringRedisOneTemplate")
//    public StringRedisTemplate stringRedisOneTemplate() {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory(redis1_host, redis1_port, redis1_password,redis1_database));
//        return stringRedisTemplate;
//    }

    @Bean(name = "redisTwoTemplate")
    public RedisTemplate redisTwoTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(defaultRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

//    @Bean(name = "stringRedisTwoTemplate")
//    public StringRedisTemplate stringRedisTwoTemplate() {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory(redis2_host, redis2_port, redis2_password,redis2_database));
//        return stringRedisTemplate;
//    }

    private JedisPoolConfig setPoolConfig(int maxIdle, int minIdle, int maxActive) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxActive);
        return poolConfig;
    }


    public void setSerializer(RedisTemplate template){
        RedisSerializer stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
    }


}
