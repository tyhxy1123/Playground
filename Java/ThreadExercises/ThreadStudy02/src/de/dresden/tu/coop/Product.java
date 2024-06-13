package de.dresden.tu.coop;

public class Product {
    private int id;
    private static int ID = 0;

    public Product() {
        this.id = ID++;
    }

    public int getId() {
        return id;
    }
}
