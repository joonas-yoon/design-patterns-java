package main.designpatterns.strategy.walking;

public class Bipedalism implements Walkable {

    public int step() {
        System.out.println("Use 2 leg to walk");
        return 2;
    }
}
