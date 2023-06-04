package test.observer;

import main.designpatterns.observer.ForecastDisplay;
import main.designpatterns.observer.Time;
import main.designpatterns.observer.WeatherChart;
import main.designpatterns.observer.WeatherData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseUnitTest;

class ObserverTest extends BaseUnitTest {

    @Test
    @DisplayName("ForecastDisplay observes WeatherData")
    public void testForecastObservingWeather() {
        WeatherData weatherData = new WeatherData();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        println("# Start observing");
        weatherData.addObserver(forecastDisplay);
        println(forecastDisplay.getMessage());

        println("Temperature changed");
        weatherData.setTemperature(23.3f);
        println(forecastDisplay.getMessage());

        println("Humidity changed");
        weatherData.setHumidity(0.74f);
        println(forecastDisplay.getMessage());

        println("Temperature changed");
        weatherData.setTemperature(28.7f);
        println(forecastDisplay.getMessage());

        println("# Stop observing");
        weatherData.deleteObserver(forecastDisplay);

        println("Temperature changed");
        weatherData.setTemperature(26.3f);
        println(forecastDisplay.getMessage());

        assertPrintsTrue();
    }

    @Test
    @DisplayName("WeatherChart observes WeatherData")
    public void testChartObservingWeather() {
        WeatherData weatherData = new WeatherData();
        WeatherChart chart = new WeatherChart();

        println("# Start observing");
        weatherData.addObserver(chart);

        println(chart.toJsonString());

        println("Weather changed");
        weatherData.set(23.3f, 0.85f, 1015);
        println(chart.toJsonString());

        println("Weather changed");
        weatherData.set(25.6f, 0.83f, 1012);
        println(chart.toJsonString());

        println("# Stop observing");
        weatherData.deleteObserver(chart);

        println("Weather changed");
        weatherData.set(26.7f, 0.82f, 1010);
        println(chart.toJsonString());

        assertPrintsTrue();
    }

    @Test
    @DisplayName("WeatherChart observes WeatherData and Time")
    public void testObservingWeatherAndTime() {
        Time current = new Time();
        WeatherData weatherData = new WeatherData();

        WeatherChart chart = new WeatherChart();

        println("# Start observing");
        weatherData.addObserver(chart);
        current.addObserver(chart);

        println(chart.toJsonString());

        println("Weather changed");
        weatherData.set(23.3f, 0.85f, 1015);
        println(chart.toJsonString());

        println("Time and weather changed");
        current.tick(1000);
        weatherData.set(25.6f, 0.83f, 1012);
        println(chart.toJsonString());

        println("Time changed");
        current.tick(1000);
        println(chart.toJsonString());

        println("# Stop observing");
        weatherData.deleteObserver(chart);

        println("Weather changed");
        weatherData.set(24.9f, 0.86f, 1014);
        println(chart.toJsonString());

        println("Time changed");
        current.tick(1000);
        println(chart.toJsonString());

        assertPrintsTrue();
    }

    @Test
    @DisplayName("Restart observing")
    public void testRestartObserving() {
        Time current = new Time(3, 10, 0);
        WeatherChart chart = new WeatherChart();

        println("# Start observing");
        current.addObserver(chart);

        println("Time changed");
        current.tick(1000);
        println(chart.toJsonString());

        println("# Stop observing");
        current.deleteObserver(chart);

        println("Time changed");
        current.tick(1000);
        println(chart.toJsonString());

        println("# Restart observing");
        current.addObserver(chart);

        println("Time changed");
        current.set(12, 10, 30);
        println(chart.toJsonString());

        assertPrintsTrue();
    }
}