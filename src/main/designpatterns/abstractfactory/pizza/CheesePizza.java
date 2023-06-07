package main.designpatterns.abstractfactory.pizza;

import main.designpatterns.abstractfactory.FoodFactory;
import main.designpatterns.abstractfactory.Pizza;

public class CheesePizza extends Pizza {

    FoodFactory factory;

    public CheesePizza(FoodFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        toppings.addAll(factory.createToppings());
    }
}
