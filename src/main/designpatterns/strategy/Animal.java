package main.designpatterns.strategy;

import main.designpatterns.strategy.walking.NotMovable;
import main.designpatterns.strategy.walking.Walkable;

public class Animal {

    Walkable howToWalk;

    public Animal() {
        howToWalk = new NotMovable();
    }

    public void setWalkingType(Walkable howToWalk) {
        this.howToWalk = howToWalk;
    }

    /**
     * @return Integer is how many footprints after walking
     */
    public int walk() {
        return howToWalk.step();
    }
}
