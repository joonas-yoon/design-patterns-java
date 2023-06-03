package main.designpatterns.strategy.walking;

public class Bipedalism implements Walkable {

    public void step() {
        System.out.println("Use 2 leg to walk");
    }
}
