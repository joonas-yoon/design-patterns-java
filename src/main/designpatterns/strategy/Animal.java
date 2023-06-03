package main.designpatterns.strategy;

import main.designpatterns.strategy.walking.NotMovable;
import main.designpatterns.strategy.walking.Walkable;

public class Animal {

    Walkable howToWalk;

    public Animal() {
        howToWalk = new NotMovable();
    }

    public void setWalkingWay(Walkable howToWalk) {
        this.howToWalk = howToWalk;
    }

    public void walk() {
        howToWalk.step();
    }
}
