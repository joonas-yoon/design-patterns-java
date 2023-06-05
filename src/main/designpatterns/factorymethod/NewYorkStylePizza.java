package main.designpatterns.factorymethod;

public class NewYorkStylePizza extends Pizza {

    public NewYorkStylePizza() {
        super();
        name = "New York Style Pizza";
        dough = "Thin crust";
        sauce = "Marinara sauce";
        toppings.add("dry mozzarella cheese");
        toppings.add("parmesan cheese");
    }
}
