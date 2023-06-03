package main.designpatterns.strategy.flying;

public class FlyWithWings implements Flyable {

    @Override
    public String fly() {
        return "Woosh";
    }
}
