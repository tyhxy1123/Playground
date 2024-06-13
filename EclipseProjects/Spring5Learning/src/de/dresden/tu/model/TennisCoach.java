package de.dresden.tu.model;

import org.springframework.stereotype.Component;

import de.dresden.tu.service.FortuneService;

@Component
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
