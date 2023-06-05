package main.designpatterns.decorator;

import java.util.Arrays;

public class DetroitPizza extends Pizza {

    public DetroitPizza() {
        toppings = Arrays.asList(
                "Tomato sauce",
                "Pepperoni",
                "Mozzarella cheese",
                "Cheddar cheese");
        dough.setShape(Dough.Shape.RECTANGLE);
    }

    @Override
    public int getPrice() {
        return 6000;
    }
}
