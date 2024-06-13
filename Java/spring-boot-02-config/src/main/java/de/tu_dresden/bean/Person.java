package de.tu_dresden.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


/**
 * 将配置中的每一个值映射到这个组件中
 *
 * @author xiangyu
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * Prefix = "person": 配置文件中person下面的所有属性进行一一映射
 * <p>
 * 只有这个容器中的组件，才能使用容器提供的@ConfigurationProperties功能
 */


//@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private int age;
    private List<String> cars;
    private boolean boss;
    private Date birthday;

    private Map<String, Object> map;

    private Dog dog;


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", cars=" + cars + ", boss=" + boss + ", birthday=" + birthday
                + ", map=" + map + ", dog=" + dog + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }


    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


}