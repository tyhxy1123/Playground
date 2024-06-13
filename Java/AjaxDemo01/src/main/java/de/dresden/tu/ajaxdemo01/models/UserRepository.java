package de.dresden.tu.ajaxdemo01.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


@PropertySource(value = "classpath:repository.properties")
@ConfigurationProperties(prefix = "userrepository")
@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private List<User> repository;

    public UserRepository(List<User> repository) {
        this.repository = repository;
//        repository = new ArrayList<>();
//        repository.add(new User("张三", 18));
//        repository.add(new User("李四", 19));
//        repository.add(new User("王五", 20));
    }

    @Override
    public void addUser(User user){
        if(repository.isEmpty()){
            user.setId(1);
            repository.add(user);
        }
        else {
            user.setId(repository.stream().max(Comparator.comparing(User::getId)).orElseThrow(NoSuchElementException::new).getId() + 1);
        }
    }

    @Override
    public User getUserById(long id) {
        return repository.stream().filter(u->u.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "repository=" + repository +
                '}';
    }
}
