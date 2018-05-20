package com.intellisignals.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
@ConditionalOnExpression("'${job.name}'.equals('archive.job')")
public class ArchiveJob implements CommandLineRunner{

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostConstruct
    public void init() throws InterruptedException {

        logger.debug("Hello world");
        IntStream.range(1,100).forEach( i -> logger.info(Integer.toString(i)));
        Thread.sleep(5000);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
