package main.designpatterns.factorymethod;

public class NewYorkPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new NewYorkCheesePizza();
            case "pepperoni" -> new NewYorkPepperoniPizza();
            default -> null;
        };
    }
}

class NewYorkCheesePizza extends NewYorkStylePizza {

    NewYorkCheesePizza() {
        super();
        name = "New York Style Cheese Pizza";
    }
}

class NewYorkPepperoniPizza extends NewYorkStylePizza {

    NewYorkPepperoniPizza() {
        super();
        name = "New York Style Pepperoni Pizza";
        toppings.add("Pepperoni");
    }
}
