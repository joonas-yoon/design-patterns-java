package main.designpatterns.strategy;

import main.designpatterns.strategy.walking.Bipedalism;

public class Human extends Animal {

    public Human() {
        howToWalk = new Bipedalism();
    }
}
