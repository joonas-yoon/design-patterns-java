package main.designpatterns.singleton.withenum;

public enum Database {

    INSTANCE;

    private String currentTime;

    Database() {
        currentTime = "";
    }

    public void setCurrentTime(String timeString) {
        this.currentTime = timeString;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
