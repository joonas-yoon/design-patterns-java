package main.designpatterns.strategy.walking;

public class NotMovable implements Walkable {

    public void step() {
        System.out.println("Can't not move");
    }
}
