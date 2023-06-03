package main.designpatterns.strategy;

import main.designpatterns.strategy.flying.FlyNoWay;
import main.designpatterns.strategy.flying.Flyable;
import main.designpatterns.strategy.walking.NotMovable;
import main.designpatterns.strategy.walking.Walkable;

public class Animal {

    Walkable howToWalk;
    Flyable howToFly;

    public Animal() {
        // Default behaviors
        howToWalk = new NotMovable();
        howToFly = new FlyNoWay();
    }

    public void setWalkingType(Walkable howToWalk) {
        this.howToWalk = howToWalk;
    }

    public void setFlyingType(Flyable howToFly) {
        this.howToFly = howToFly;
    }

    /**
     * @return Integer is how many footprints after walking
     */
    public int walk() {
        return howToWalk.step();
    }

    /**
     * @return String is what it sounds
     */
    public String fly() {
        return howToFly.fly();
    }
}
