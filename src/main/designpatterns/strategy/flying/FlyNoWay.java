package main.designpatterns.strategy.flying;

public class FlyNoWay implements Flyable {

    @Override
    public String fly() {
        return "Can not fly";
    }
}
