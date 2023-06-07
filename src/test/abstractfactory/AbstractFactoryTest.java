package test.abstractfactory;

import main.designpatterns.abstractfactory.ChicagoPizzaStore;
import main.designpatterns.abstractfactory.NewYorkPizzaStore;
import main.designpatterns.abstractfactory.Pizza;
import main.designpatterns.abstractfactory.PizzaStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

public class AbstractFactoryTest extends BaseUnitTest {

    @Test
    @DisplayName("NewYorkPizzaStore creates pizza")
    public void testOrderPizza() {
        PizzaStore storeAtNewYork = new NewYorkPizzaStore();
        PizzaStore storeAtChicago = new ChicagoPizzaStore();

        println("# Order NY Style cheese pizza");
        Pizza pizzaCheeseNY = storeAtNewYork.orderPizza("cheese");
        println("got pizza: " + pizzaCheeseNY);

        println("# Order Chicago Style cheese pizza");
        Pizza pizzaCheeseCH = storeAtChicago.orderPizza("cheese");
        println("got pizza: " + pizzaCheeseCH);

        println("# Order NY Style pepperoni pizza");
        Pizza pizzaPepperoniNY = storeAtNewYork.orderPizza("pepperoni");
        println("got pizza: " + pizzaPepperoniNY);

        println("# Order Chicago Style pepperoni pizza");
        Pizza pizzaPepperoniCH = storeAtChicago.orderPizza("pepperoni");
        println("got pizza: " + pizzaPepperoniCH);

        println("# Order NY Style veggie pizza");
        Pizza pizzaVeggieNY = storeAtNewYork.orderPizza("veggies");
        println("got pizza: " + pizzaVeggieNY);

        println("# Order Chicago Style veggie pizza");
        Pizza pizzaVeggieCH = storeAtChicago.orderPizza("veggies");
        println("got pizza: " + pizzaVeggieCH);

        assertPrintsTrue();
    }
}
