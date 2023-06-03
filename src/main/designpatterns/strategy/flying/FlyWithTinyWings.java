package main.designpatterns.strategy.flying;

public class FlyWithTinyWings implements Flyable {

    @Override
    public String fly() {
        return "Buzz";
    }
}
