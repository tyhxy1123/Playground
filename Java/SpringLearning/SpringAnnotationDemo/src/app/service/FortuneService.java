package app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FortuneService implements IService {
    @Override
    public String getFortune(){
        Random random = new Random();
        String[] data = {"Just do it", "Do it step by step", "Diligence is the mother of good luck"};
        return data[random.nextInt(data.length)];
    }
}
