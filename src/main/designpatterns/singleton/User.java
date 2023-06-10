package main.designpatterns.singleton;

public class User {

    private final String name;
    private String description;

    public User(String name) {
        this.name = name;
        this.description = "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("User(%s=%s})", name, description);
    }
}
