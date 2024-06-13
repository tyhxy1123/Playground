package de.dresden.tu.ajaxdemo01;

import de.dresden.tu.ajaxdemo01.models.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ajaxdemo01ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    UserRepository repository;

    @Test
    public void testRepository(){
        System.out.println(repository);
    }

}
