package spring.annotation.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.annotation.demo.model.ICoach;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
		ICoach theCoach = cxt.getBean("theCoach", ICoach.class);
	}
}
