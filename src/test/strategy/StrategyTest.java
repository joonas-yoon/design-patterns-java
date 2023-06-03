package test.strategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import main.designpatterns.strategy.Animal;
import main.designpatterns.strategy.Cat;
import main.designpatterns.strategy.Dog;
import main.designpatterns.strategy.Human;
import main.designpatterns.strategy.walking.Bipedalism;
import main.designpatterns.strategy.walking.Quadrupedalism;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testWalkPolymorph() {
        Animal human = new Human();
        Animal dog = new Dog();
        Animal cat = new Cat();
        for (Animal animal : Arrays.asList(human, dog, cat)) {
            System.out.print(animal.getClass().getSimpleName() + ": ");
            animal.walk();
        }

        Approvals.verify(outContent.toString());
    }

    @Test
    public void testWalkChangeDynamically() {
        Animal human = new Human();

        human.setWalkingWay(new Quadrupedalism());
        human.walk();

        human.setWalkingWay(new Bipedalism());
        human.walk();

        Approvals.verify(outContent.toString());
    }
}