package de.dresden.tu.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.dresden.tu.model.ICoach;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICoach theCoach = cxt.getBean("theCoach", ICoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.toString());
		cxt.close();
	}
}
