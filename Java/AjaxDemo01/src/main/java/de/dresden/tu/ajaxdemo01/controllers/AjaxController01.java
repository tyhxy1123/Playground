package de.dresden.tu.ajaxdemo01.controllers;

import de.dresden.tu.ajaxdemo01.models.User;
import de.dresden.tu.ajaxdemo01.models.UserFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController01 {

    @RequestMapping("/a1")
    public List<User> response01(){
        List<User> list = new ArrayList<>();
        list.add(UserFactory.getUser("张三", 18));
        list.add(UserFactory.getUser("张四", 28));
        list.add(UserFactory.getUser("张五", 38));
        list.add(UserFactory.getUser("张六", 48));
        list.add(UserFactory.getUser("张七", 58));
        return list;
    }

}
