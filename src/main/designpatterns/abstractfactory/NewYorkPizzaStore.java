package main.designpatterns.abstractfactory;

import main.designpatterns.abstractfactory.pizza.CheesePizza;
import main.designpatterns.abstractfactory.pizza.PepperoniPizza;
import main.designpatterns.abstractfactory.pizza.VeggiePizza;

import java.util.List;

public class NewYorkPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        FoodFactory factory = new NewYorkFoodFactory();
        return switch (type) {
            case "cheese" -> {
                Pizza pizza = new CheesePizza(factory);
                pizza.setName("NewYork Style Cheese Pizza");
                yield pizza;
            }
            case "pepperoni" -> {
                Pizza pizza = new PepperoniPizza(factory);
                pizza.setName("NewYork Style Pepperoni Pizza");
                yield pizza;
            }
            case "veggies" -> {
                Pizza pizza = new VeggiePizza(factory);
                pizza.setName("NewYork Style Veggie Pizza");
                yield pizza;
            }
            default -> null;
        };
    }
}

class NewYorkFoodFactory implements FoodFactory {
    @Override
    public String createDough() {
        return "Thin crispy and chewy dough";
    }

    @Override
    public String createSauce() {
        return "Thick and rich sauce";
    }

    @Override
    public String createCheese() {
        return "Mozzarella and parmesan and provolone cheeses";
    }

    @Override
    public String createVeggies() {
        return "Spinach and broccoli and tomatoes";
    }

    @Override
    public List<String> createToppings() {
        return List.of("pepperoni", "sausage", "mushrooms", "onions",
                "peppers", "olives", "green peppers");
    }
}