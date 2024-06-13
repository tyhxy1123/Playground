package spring.annotation.demo.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	public String getDailyFortune() {
		Random random = new Random();
		String[] data = {"Just do it", "Today is a lucky day", "Do it step by step"};
		return data[random.nextInt(data.length)];
	}
}

