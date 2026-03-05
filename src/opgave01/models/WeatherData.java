package opgave01.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements WeatherSubject {
    private Random random = new Random();

    private float temp;
    private float humidity;
    private float pressure;

    private List<WeatherObserver> observers = new ArrayList<>();

    public void measurementsChanged() {
        notifyWeatherObserver();
    }

    public void setMeasurements(){
        temp = getTemperature();
        humidity = getHumidity();
        pressure = getPressure();
        measurementsChanged();
    }

    public void registrerWeatherObserver(WeatherObserver weatherObserver) {
        if (!observers.contains(weatherObserver)) observers.add(weatherObserver);
    }

    @Override
    public void removeWeatherObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyWeatherObserver() {
        for (WeatherObserver observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }

    private float getTemperature() {
        return Math.round(random.nextFloat(-20, 40) * 100) / 100.0f;
    }

    private float getHumidity() {
        return Math.round(random.nextFloat(2, 98));
    }

    private float getPressure() {
        return random.nextInt(900, 1080);
    }
}
