package SimpleFactory;

public abstract class PizzaStore {
    public void orderPizza(PizzaType type){
        Pizza pizza = createPizza(type);
        System.out.println("ordered pizza: " + pizza.toString());
    }

    public abstract Pizza createPizza(PizzaType type);
}
