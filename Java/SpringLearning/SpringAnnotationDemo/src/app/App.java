package app;

import app.config.SportConfig;
import app.model.ICoach;
import app.model.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach theSwimCoach = cxt.getBean("swimCoach", SwimCoach.class);
        System.out.println(theSwimCoach.getDailyWorkout());
        System.out.println(theSwimCoach.getDailyFortune());
        System.out.println(theSwimCoach.getEmail());
        System.out.println(theSwimCoach.getClub());
        cxt.close();
    }
}
