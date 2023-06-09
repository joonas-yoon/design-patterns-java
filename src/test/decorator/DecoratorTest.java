package test.decorator;

import main.designpatterns.decorator.DetroitPizza;
import main.designpatterns.decorator.HawaiianPizza;
import main.designpatterns.decorator.Pizza;
import main.designpatterns.decorator.options.GlutenFreePizza;
import main.designpatterns.decorator.options.HotSaucePizza;
import main.designpatterns.decorator.options.VeganPizza;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

class DecoratorTest extends BaseUnitTest {

    @Test
    public void testDecorateTopping() {
        println("# Create new HawaiianPizza");
        Pizza pizza = new HawaiianPizza();
        println(toString(pizza));

        println("Add HotSauced option");
        HotSaucePizza hotSaucedPizza = new HotSaucePizza(pizza);
        println(toString(hotSaucedPizza));

        println("Add HotSauced option");
        HotSaucePizza superHotPizza = new HotSaucePizza(hotSaucedPizza);
        println(toString(superHotPizza));

        println("Add ForVegan option");
        VeganPizza superHotVeganPizza = new VeganPizza(superHotPizza);
        println(toString(superHotVeganPizza));

        assertPrintsTrue();
    }

    @Test
    public void testDecorateDough() {
        println("# Create new DetroitPizza");
        Pizza pizza2 = new DetroitPizza();
        println(toString(pizza2));

        println("Add GlutenFree option");
        GlutenFreePizza glutenFreePizza2 = new GlutenFreePizza(pizza2);
        println(toString(glutenFreePizza2));

        assertPrintsTrue();
    }

    private static String toString(Pizza pizza) {
        return pizza + ", price=" + pizza.getPrice() + "\n";
    }
}