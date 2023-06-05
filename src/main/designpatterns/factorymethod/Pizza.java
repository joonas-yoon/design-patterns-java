package main.designpatterns.factorymethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pizza {

    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public void cook() {
        sauce += " (grilled)";
        System.out.println("Cook: " + this);
    }

    public void cut() {
        dough += " (sliced)";
        System.out.println("Cut: " + this);
    }

    @Override
    public String toString() {
        return String.format("Pizza {name=%s, dough=%s, sauce=%s, toppings=%s}",
                name, dough, sauce, Arrays.toString(toppings.toArray()));
    }
}
