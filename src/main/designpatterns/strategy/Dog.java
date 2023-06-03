package main.designpatterns.strategy;

import main.designpatterns.strategy.walking.Quadrupedalism;

public class Dog extends Animal {

    public Dog() {
        howToWalk = new Quadrupedalism();
    }
}
