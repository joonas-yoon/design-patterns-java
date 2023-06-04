package main.designpatterns.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private float humidity;
    private float temperature;
    private float pressure;

    public WeatherData() {
        humidity = 0;
        temperature = 0;
        pressure = 0;
    }

    public void set(float humidity, float temperature, float pressure) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        dataUpdated();
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        dataUpdated();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        dataUpdated();
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        dataUpdated();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    private void dataUpdated() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return String.format("humidity: %3.2f, temperature: %3.2f, pressure: %3.2f",
                humidity, temperature, pressure);
    }
}
