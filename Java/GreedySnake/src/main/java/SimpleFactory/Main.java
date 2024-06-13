package SimpleFactory;

public final class Main {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        store.orderPizza(PizzaType.Pepperoni);
    }
}
