package main.designpatterns.decorator.options;

import java.util.List;
import main.designpatterns.decorator.Pizza;
import main.designpatterns.decorator.PizzaTopper;

public class HotSaucePizza extends PizzaTopper {

    private static final int HOT_SAUCE_PRICE = 300;

    public HotSaucePizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + HOT_SAUCE_PRICE;
    }

    @Override
    public List<String> getToppings() {
        List<String> toppings = pizza.getToppings();
        toppings.add("Hot sauce");
        return toppings;
    }
}
