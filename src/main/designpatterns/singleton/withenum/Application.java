package main.designpatterns.singleton.withenum;

import main.designpatterns.singleton.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private final List<User> users;

    public Application() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        Database db = Database.INSTANCE;
        user.setDescription("{last login: " + db.getCurrentTime() + "}");
        users.add(user);
    }

    public String getLogs() {
        return Arrays.toString(users.toArray());
    }
}
