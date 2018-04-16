package com.intellisignals.job;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import com.intellisignals.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Component
@ConditionalOnExpression("'${job.name}'.equals('cache.job')")
public class CacheHazelcastJob implements CommandLineRunner{


    private HazelcastInstance hzInstance;

    @Value("${num.rows:10}")
    private int numRows;

    @PostConstruct
    public void init() throws UnsupportedEncodingException {


        hzInstance = Hazelcast.newHazelcastInstance();

        Map<Long, Person> map = hzInstance.getMap("data");

        IdGenerator idGenerator = hzInstance.getIdGenerator("newid");
        for (int i = 0; i < numRows; i++) {
            Person person = new Person();
            map.put(idGenerator.newId(), person);
        }
    }

    @Override
    public void run(String... strings) throws Exception {

    }

}
