package de.dresden.tu.coop;

public class SynContainer {
    Product[] products = new Product[10];
    int count = 0;

    public synchronized void push(Product product) {
        if (count == products.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            products[count++] = product;
            this.notify();
        }
    }

    public synchronized Product pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product toReturn = products[--count];
        this.notify();
        return toReturn;

    }
}
