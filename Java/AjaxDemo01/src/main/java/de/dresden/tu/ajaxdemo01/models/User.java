package de.dresden.tu.ajaxdemo01.models;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.beans.JavaBean;

@Component
@Data
public class User {

    private String name;
    private int age;
    private long id;

}
