package test.strategy;

import java.util.Arrays;
import main.designpatterns.strategy.Animal;
import main.designpatterns.strategy.Cat;
import main.designpatterns.strategy.Dog;
import main.designpatterns.strategy.Human;
import main.designpatterns.strategy.walking.Bipedalism;
import main.designpatterns.strategy.walking.Quadrupedalism;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

public class StrategyTest extends BaseUnitTest {

    @Test
    public void testWalkPolymorph() {
        Animal human = new Human();
        Animal dog = new Dog();
        Animal cat = new Cat();
        for (Animal animal : Arrays.asList(human, dog, cat)) {
            System.out.print(animal.getClass().getSimpleName() + ": ");
            animal.walk();
        }

        assertStdoutTrue();
    }

    @Test
    public void testWalkChangeDynamically() {
        Animal human = new Human();

        human.setWalkingWay(new Quadrupedalism());
        human.walk();

        human.setWalkingWay(new Bipedalism());
        human.walk();

        assertStdoutTrue();
    }
}