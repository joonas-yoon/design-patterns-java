package main.designpatterns.singleton;

public class Database {

    private static volatile Database instance;
    private String currentTime = "";

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public void setCurrentTime(String timeString) {
        this.currentTime = timeString;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
