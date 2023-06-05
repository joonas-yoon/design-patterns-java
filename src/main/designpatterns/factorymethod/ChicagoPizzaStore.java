package main.designpatterns.factorymethod;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new ChicagoCheesePizza();
            case "pepperoni" -> new ChicagoPepperoniPizza();
            default -> null;
        };
    }
}

class ChicagoCheesePizza extends ChicagoStylePizza {

    ChicagoCheesePizza() {
        super();
        name = "New York Style Cheese Pizza";
    }
}

class ChicagoPepperoniPizza extends ChicagoStylePizza {

    ChicagoPepperoniPizza() {
        super();
        name = "New York Style Pepperoni Pizza";
        toppings.add("Pepperoni");
    }
}
