package main.designpatterns.decorator;

import java.util.List;

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
