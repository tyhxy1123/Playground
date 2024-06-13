package app.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.service.FortuneService;


@Component("theCoach")
public class TennisCoach implements ICoach {

	
	private FortuneService fortuneService;
	private String email;

	@Override
	public String getDailyWorkout() {
		return "run a hard 5k";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
	

	@Override
	public String toString() {
		return "TennisCoach [fortuneService=" + fortuneService + ", email=" + email + "]";
	}

	public TennisCoach() {}
	@Autowired
	public TennisCoach(FortuneService service) {
		this.fortuneService = service;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
