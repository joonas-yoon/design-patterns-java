package main.designpatterns.decorator;

import java.util.Arrays;

public class HawaiianPizza extends Pizza {

    public HawaiianPizza() {
        toppings = Arrays.asList("Tomato sauce", "Pineapple", "Bacon", "Cheese");
    }

    @Override
    public int getPrice() {
        return 8000;
    }
}
