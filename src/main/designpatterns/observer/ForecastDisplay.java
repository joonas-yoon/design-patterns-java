package main.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer {

    private String message = "<Nothing to display>";

    private boolean isFirstDetect = true;
    private float lastTemperature = 0;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            float detected = weatherData.getTemperature();
            if (isFirstDetect) {
                updateMessage(detected, detected);
                isFirstDetect = false;
            } else {
                float nextTemperature = predictTemperature(detected);
                updateMessage(detected, nextTemperature);
            }
            lastTemperature = detected;
        }
    }

    public String getMessage() {
        return message;
    }

    public float predictTemperature(float newTemperature) {
        float diff = newTemperature - this.lastTemperature;
        return this.lastTemperature + 0.5f * diff;
    }

    private void updateMessage(float current, float predict) {
        this.message = String.format(
                "[Forecast] current: %3.2f('C), expected next: %3.2f('C)",
                current, predict);
    }
}
