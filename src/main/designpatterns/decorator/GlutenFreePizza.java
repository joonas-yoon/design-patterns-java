package main.designpatterns.decorator;

import java.util.List;

public class GlutenFreePizza extends PizzaTopper {

    private static final int GLUTEN_FREE_PRICE = 4000;

    public GlutenFreePizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + GLUTEN_FREE_PRICE;
    }

    @Override
    public Dough getDough() {
        Dough newDough = pizza.getDough();
        newDough.setStyle(Dough.Style.GLUTEN_FREE);
        return newDough;
    }

    @Override
    public List<String> getToppings() {
        return pizza.getToppings();
    }
}
