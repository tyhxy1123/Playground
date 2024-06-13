package app.model;

import app.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach{

    @Autowired
    @Qualifier("fortuneService")
    private IService service;
    @Value("${email}")
    private String email;

    @Override
    public String getDailyWorkout() {
        return "run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

    @Override
    public String toString() {
        return "TennisCoach [fortuneService=" + service + ", email=" + email + "]";
    }
}
