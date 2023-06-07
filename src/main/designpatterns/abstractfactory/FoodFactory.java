package main.designpatterns.abstractfactory;

import java.util.List;

public interface FoodFactory {
    String createDough();

    String createSauce();

    String createCheese();

    String createVeggies();

    List<String> createToppings();
}
