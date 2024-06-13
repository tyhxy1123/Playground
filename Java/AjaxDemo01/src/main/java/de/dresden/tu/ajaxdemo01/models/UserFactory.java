package de.dresden.tu.ajaxdemo01.models;

import de.dresden.tu.ajaxdemo01.models.User;

public class UserFactory {
    public static User getUser(String name, int age){
        return new User();
    }
}
