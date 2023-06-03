package main.designpatterns.strategy.walking;

public class NotMovable implements Walkable {

    public int step() {
        System.out.println("Can't not move");
        return 0;
    }
}
