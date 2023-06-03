package main.designpatterns.strategy;

import main.designpatterns.strategy.walking.Quadrupedalism;

public class Cat extends Animal {

    public Cat() {
        howToWalk = new Quadrupedalism();
    }
}
