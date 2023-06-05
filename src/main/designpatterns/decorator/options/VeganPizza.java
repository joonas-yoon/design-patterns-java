package main.designpatterns.decorator.options;

import java.util.List;
import java.util.Set;
import main.designpatterns.decorator.Pizza;
import main.designpatterns.decorator.PizzaTopper;

public class VeganPizza extends PizzaTopper {

    private static final int VEGAN_PRICE = 3000;

    public VeganPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + VEGAN_PRICE;
    }

    @Override
    public List<String> getToppings() {
        List<String> toppings = pizza.getToppings();
        toppings.removeAll(Set.of("Ham", "Bacon"));
        toppings.replaceAll(topping -> {
            boolean hasCheese = topping.toLowerCase().contains("cheese");
            if (!hasCheese) {
                return topping;
            }
            return "Vegan cheese";
        });
        return toppings;
    }
}