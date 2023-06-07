package main.designpatterns.abstractfactory.pizza;

import main.designpatterns.abstractfactory.FoodFactory;
import main.designpatterns.abstractfactory.Pizza;

public class VeggiePizza extends Pizza {

    FoodFactory factory;

    public VeggiePizza(FoodFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        dough = factory.createDough();
        sauce = factory.createSauce();
        veggies = factory.createVeggies();
        toppings.addAll(factory.createToppings());
    }
}
