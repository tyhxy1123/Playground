package de.dresden.tu.service;

import java.util.Random;

public class FortuneService {
	public String getDailyFortune() {
		Random random = new Random();
		String[] data = {"Just do it", "Today is a lucky day", "Do it step by step"};
		return data[random.nextInt(data.length)];
	}
}
