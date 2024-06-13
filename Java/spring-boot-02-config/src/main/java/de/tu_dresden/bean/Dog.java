package de.tu_dresden.bean;

public class Dog {
    private String name;


    @Override
    public String toString() {
        return "Dog [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
