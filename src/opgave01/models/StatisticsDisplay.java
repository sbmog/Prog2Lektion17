package opgave01.models;

import java.util.ArrayList;

public class StatisticsDisplay implements WeatherObserver {

    private ArrayList<Float> temperatures;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        temperatures = new ArrayList<>();
        this.weatherData = weatherData;
        weatherData.registrerWeatherObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        temperatures.add(temp);
        display();
    }

    private void display() {
        System.out.println("Temperature statistics: avg: " + averageTemperature() + " max: " + maxTemp() + " min: " + minTemp());
    }

    private float averageTemperature() {
        float sum = 0;
        for (Float temperature : temperatures) {
            sum += temperature;
        }
        return sum / temperatures.size();
    }

    private float maxTemp() {
        float max = 0;
        for (Float temperature : temperatures) {
            if (temperature > max) max = temperature;
        }
        return max;
    }

    private float minTemp() {
        float min = 0;
        for (Float temperature : temperatures) {
            if (temperature < min) min = temperature;
        }
        return min;
    }
}