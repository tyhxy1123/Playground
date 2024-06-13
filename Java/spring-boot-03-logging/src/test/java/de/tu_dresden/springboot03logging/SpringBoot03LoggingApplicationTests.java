package de.tu_dresden.springboot03logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        //日志的级别，由低到高
        logger.trace("This is Trace log...");
        logger.debug("This is Debug log...");
        logger.info("THis is Info log...");
        logger.warn("This is warn log...");
        logger.error("This is error log...");

    }

}
