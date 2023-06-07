package main.designpatterns.abstractfactory;

import main.designpatterns.abstractfactory.pizza.CheesePizza;
import main.designpatterns.abstractfactory.pizza.PepperoniPizza;
import main.designpatterns.abstractfactory.pizza.VeggiePizza;

import java.util.List;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        FoodFactory factory = new ChicagoFoodFactory();
        return switch (type) {
            case "cheese" -> {
                Pizza pizza = new CheesePizza(factory);
                pizza.setName("Chicago Style Cheese Pizza");
                yield pizza;
            }
            case "pepperoni" -> {
                Pizza pizza = new PepperoniPizza(factory);
                pizza.setName("Chicago Style Pepperoni Pizza");
                yield pizza;
            }
            case "veggies" -> {
                Pizza pizza = new VeggiePizza(factory);
                pizza.setName("Chicago Style Veggie Pizza");
                yield pizza;
            }
            default -> null;
        };
    }
}

class ChicagoFoodFactory implements FoodFactory {
    @Override
    public String createDough() {
        return "Thick deep-dish and buttery dough";
    }

    @Override
    public String createSauce() {
        return "Thin and tangy sauce";
    }

    @Override
    public String createCheese() {
        return "Mozzarella cheese";
    }

    @Override
    public String createVeggies() {
        return "Eggplant, jalapenos";
    }

    @Override
    public List<String> createToppings() {
        return List.of("pepperoni", "sausage", "mushrooms", "onions", "peppers", "olives");
    }
}
