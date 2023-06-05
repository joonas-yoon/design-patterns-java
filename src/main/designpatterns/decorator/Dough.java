package main.designpatterns.decorator;

public class Dough {

    protected Style style;
    protected Shape shape;

    public Dough() {
        style = Style.PLAIN;
        shape = Shape.CIRCLE;
    }

    public Dough(Dough dough) {
        this.style = dough.style;
        this.shape = dough.shape;
    }

    public enum Style {
        PLAIN,
        NEAPOLITAN,
        FERMENTED,
        NEW_YORK,
        GLUTEN_FREE
    }

    public enum Shape {
        CIRCLE,
        RECTANGLE
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return style + "/" + shape;
    }
}
