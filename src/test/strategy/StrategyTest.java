package test.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            String className = animal.getClass().getSimpleName();
            int steps = animal.walk();
            switch (className) {
                case "Human":
                    assertEquals(2, steps);
                    break;
                case "Dog":
                case "Cat":
                    assertEquals(4, steps);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void testWalkChangeDynamically() {
        Animal human = new Human();

        human.setWalkingType(new Quadrupedalism());
        assertEquals(4, human.walk());

        human.setWalkingType(new Bipedalism());
        assertEquals(2, human.walk());
    }
}