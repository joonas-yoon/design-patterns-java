package test.singleton;

import main.designpatterns.singleton.User;
import main.designpatterns.singleton.withenum.Application;
import main.designpatterns.singleton.withenum.Database;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

class SingletonEnumTest extends BaseUnitTest {

    @Test
    @DisplayName("All applications use same Database")
    public void testDatabaseOnlyOne() {
        Database db = Database.INSTANCE;
        Application application1 = new Application();
        Application application2 = new Application();

        println("# Database time updated to 00:00:00");
        db.setCurrentTime("00:00:00");
        application1.addUser(new User("Amy"));
        application2.addUser(new User("Alice"));
        println(application1.getLogs());
        println(application2.getLogs());

        println("# Database time updated to 00:11:22");
        db.setCurrentTime("00:11:22");
        application1.addUser(new User("Bob"));
        application2.addUser(new User("Bread"));
        println(application1.getLogs());
        println(application2.getLogs());

        println("# Database time updated to 00:33:44");
        db.setCurrentTime("00:33:44)");
        application1.addUser(new User("Carl"));
        application2.addUser(new User("Chris"));
        println(application1.getLogs());
        println(application2.getLogs());

        assertPrintsTrue();
    }
}
