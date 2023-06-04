package main.designpatterns.observer;

import java.util.Observable;

public class Time extends Observable {

    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void set(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        validate();
        dataUpdated();
    }

    public void tick(int secs) {
        seconds += secs;
        validate();
        dataUpdated();
    }

    private void validate() {
        if (seconds >= 60) {
            minutes += seconds / 60;
        }
        if (minutes >= 60) {
            hours += minutes / 60;
        }
        hours %= 24;
        minutes %= 60;
        seconds %= 60;
    }

    private void dataUpdated() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
