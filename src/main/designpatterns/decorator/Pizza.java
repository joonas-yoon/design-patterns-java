package main.designpatterns.decorator;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected Dough dough = new Dough();
    protected List<String> toppings = new ArrayList<>();

    abstract public int getPrice();

    public String toString() {
        return "{Dough=" + getDough() + ", Toppings=" + getToppings() + "}";
    }

    public List<String> getToppings() {
        return new ArrayList<>(toppings);
    }

    public Dough getDough() {
        return new Dough(dough);
    }
}

