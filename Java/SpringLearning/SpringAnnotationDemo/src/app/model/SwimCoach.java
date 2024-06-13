package app.model;

import app.service.IService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements ICoach{
    @Value("${email}")
    private String email;
    @Value("${club}")
    private String club;
    private IService fortuneService;

    public SwimCoach(IService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1k meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getClub() {
        return club;
    }

}
