package main.designpatterns.abstractfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected String cheese;
    protected String veggies;
    protected List<String> toppings = new ArrayList<>();

    public abstract void prepare();

    public void setName(String name) {
        this.name = name;
    }

    public void cook() {
        if (sauce != null)
            sauce += " (grilled)";
        System.out.println("Cook: " + this);
    }

    public void cut() {
        if (dough != null)
            dough += " (sliced)";
        System.out.println("Cut: " + this);
    }

    @Override
    public String toString() {
        List<String> ingredients = List.of(
                Optional.ofNullable(dough).orElse("No dough"),
                Optional.ofNullable(sauce).orElse("No sauce"),
                Optional.ofNullable(cheese).orElse("No cheese"),
                Optional.ofNullable(veggies).orElse("No veggies")
        );
        return String.format("Pizza {name=%s, ingredients=%s, toppings=%s}",
                name, ingredients, Arrays.toString(toppings.toArray()));
    }
}
