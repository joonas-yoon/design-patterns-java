package main.designpatterns.factorymethod;

public class ChicagoStylePizza extends Pizza {

    public ChicagoStylePizza() {
        super();
        name = "Chicago Style Deep Cheese Pizza";
        dough = "Very thick crust";
        sauce = "Plum tomato sauce";
        toppings.add("sliced mozzarella cheese");
    }

    @Override
    public void cut() {
        dough += " (square)";
    }
}
