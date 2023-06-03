package main.designpatterns.strategy;

import main.designpatterns.strategy.flying.FlyWithWings;
import main.designpatterns.strategy.walking.Bipedalism;

public class Bird extends Animal {

    public Bird() {
        howToWalk = new Bipedalism();
        howToFly = new FlyWithWings();
    }
}
