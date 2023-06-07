package main.designpatterns.abstractfactory;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.cook();
        pizza.cut();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
