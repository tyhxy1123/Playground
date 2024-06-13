package de.dresden.tu.ajaxdemo01.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserRepository{
    void addUser(User user);
    User getUserById(long id);
    List<User> getAllUsers();
}
