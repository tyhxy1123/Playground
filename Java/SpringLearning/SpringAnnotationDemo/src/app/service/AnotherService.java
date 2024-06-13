package app.service;

import org.springframework.stereotype.Component;

@Component
public class AnotherService implements IService {
    @Override
    public String getFortune() {
        return "What doesn't kill me makes me stronger";
    }
}
