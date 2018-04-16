package com.intellisignals.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellisignals.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by eellpp on 25/3/18.
 */
@Component
@ConditionalOnExpression("'${job.name}'.equals('redis.job')")
public class CacheRedisJob implements CommandLineRunner{

    @Value("${num.rows:10}")
    private int numRows;

    @PostConstruct
    public void init() throws UnsupportedEncodingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Jedis jedis = new Jedis();

        Random rand = new Random();

        for (int i = 0; i < numRows; i++) {
            Person person = new Person();
            String jsonInString = mapper.writeValueAsString(person);
            String key = Integer.toString(rand.nextInt(99999999));
            jedis.hset(key,"value", jsonInString);
        }
        System.out.printf("Finished");
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
