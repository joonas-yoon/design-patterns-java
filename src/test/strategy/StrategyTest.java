package test.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import main.designpatterns.strategy.Animal;
import main.designpatterns.strategy.Bird;
import main.designpatterns.strategy.Cat;
import main.designpatterns.strategy.Dog;
import main.designpatterns.strategy.Human;
import main.designpatterns.strategy.flying.FlyWithWings;
import main.designpatterns.strategy.walking.Bipedalism;
import main.designpatterns.strategy.walking.Quadrupedalism;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

class StrategyTest extends BaseUnitTest {

    @Test
    public void testWalkPolymorph() {
        Animal human = new Human();
        Animal dog = new Dog();
        Animal cat = new Cat();

        for (Animal animal : Arrays.asList(human, dog, cat)) {
            String className = animal.getClass().getSimpleName();
            int steps = animal.walk();
            switch (className) {
                case "Human" -> assertEquals(2, steps);
                case "Dog", "Cat" -> assertEquals(4, steps);
                default -> {
                }
            }
        }
    }

    @Test
    public void testFlyPolymorph() {
        Animal human = new Human();
        Animal bird = new Bird();

        assertEquals("Can not fly", human.fly());
        assertEquals("Woosh", bird.fly());
    }

    @Test
    public void testWalkChangeDynamically() {
        Animal human = new Human();

        human.setWalkingType(new Quadrupedalism());
        assertEquals(4, human.walk());

        human.setWalkingType(new Bipedalism());
        assertEquals(2, human.walk());
    }

    @Test
    public void testFlyChangeDynamically() {
        Animal human = new Human();

        assertEquals("Can not fly", human.fly());

        human.setFlyingType(new FlyWithWings());
        assertEquals("Woosh", human.fly());
    }
}