package main.designpatterns.strategy.walking;

public class Quadrupedalism implements Walkable {

    public int step() {
        System.out.println("Use 4 leg to walk");
        return 4;
    }
}
