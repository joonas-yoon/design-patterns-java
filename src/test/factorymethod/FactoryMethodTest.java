package test.factorymethod;

import main.designpatterns.factorymethod.ChicagoPizzaStore;
import main.designpatterns.factorymethod.NewYorkPizzaStore;
import main.designpatterns.factorymethod.Pizza;
import main.designpatterns.factorymethod.PizzaStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

class FactoryMethodTest extends BaseUnitTest {

    @Test
    @DisplayName("NewYorkPizzaStore creates pizza")
    public void testOrderPizza() {
        PizzaStore storeAtNewYork = new NewYorkPizzaStore();
        PizzaStore storeAtChicago = new ChicagoPizzaStore();

        println("# Order NY Style cheese pizza");
        // pizza is created internally by store `storeAtNewYork`
        Pizza pizza1 = storeAtNewYork.orderPizza("cheese");
        println("got pizza: " + pizza1);

        println("# Order NY Style pepperoni pizza");
        Pizza pizza2 = storeAtNewYork.orderPizza("pepperoni");
        println("got pizza: " + pizza2);

        println("# Order Chicago Style cheese pizza");
        Pizza pizza3 = storeAtChicago.orderPizza("cheese");
        println("got pizza: " + pizza3);

        println("# Order Chicago Style pepperoni pizza");
        Pizza pizza4 = storeAtChicago.orderPizza("pepperoni");
        println("got pizza: " + pizza4);

        assertPrintsTrue();
    }

}
