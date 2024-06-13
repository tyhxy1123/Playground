package SimpleFactory;

public abstract class Pizza {
    String name;

    public String getName() {
        return name;
    }

    public Pizza(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
    }
}
