package de.dresden.tu.ajaxdemo01.controllers;

import de.dresden.tu.ajaxdemo01.models.IUserRepository;
import de.dresden.tu.ajaxdemo01.models.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final IUserRepository repositroy;

    public UserController(IUserRepository repositroy) {
        this.repositroy = repositroy;
    }

    @GetMapping("users/")
    public User detail(long id){
        return repositroy.getUserById(id);
    }

    @GetMapping("users/")
    public Iterable<User> getAllUsers(){
        return repositroy.getAllUsers();
    }
}
