package app.service;

import org.springframework.stereotype.Component;

@Component
public class RestService implements IService {
    @Override
    public String getFortune() {
        return "confused service";
    }
}
