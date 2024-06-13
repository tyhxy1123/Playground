package app.config;

import app.model.ICoach;
import app.model.SwimCoach;
import app.service.AnotherService;
import app.service.IService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("app")
@PropertySource("classpath:application.properties")
public class SportConfig {
    @Bean
    public ICoach swimCoach(){
        return new SwimCoach(anotherService());
    }

    @Bean
    public IService anotherService(){
        return new AnotherService();
    }


}
