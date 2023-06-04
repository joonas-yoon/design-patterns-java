package main.designpatterns.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherChart implements Observer {

    private String lastRecordTime = "";

    private final List<Float> temperatures = new ArrayList<>();
    private final List<Float> humidities = new ArrayList<>();
    private final List<Float> pressures = new ArrayList<>();

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            temperatures.add(weatherData.getTemperature());
            humidities.add(weatherData.getHumidity());
            pressures.add(weatherData.getPressure());
        }
        if (o instanceof Time) {
            lastRecordTime = o.toString();
        }
    }

    public String toJsonString() {
        String chart = "";
        chart += "\"currentTime\": \"" + lastRecordTime + "\", ";
        chart += "\"temperatures\": " + Arrays.toString(temperatures.toArray()) + ", ";
        chart += "\"humidities\": " + Arrays.toString(humidities.toArray()) + ", ";
        chart += "\"pressures\": " + Arrays.toString(pressures.toArray());
        return "{ " + chart + " }";
    }
}
