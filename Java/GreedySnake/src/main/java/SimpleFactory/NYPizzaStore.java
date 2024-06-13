package SimpleFactory;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(PizzaType type) {
        if(type == PizzaType.Pepperoni){
            return new PizzaPepperoni("New York");
        }else{
            return null;
        }
    }
}
