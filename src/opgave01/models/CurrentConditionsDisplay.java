package opgave01.models;

public class CurrentConditionsDisplay implements WeatherObserver {

    private float temp;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registrerWeatherObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("Current conditions: " + temp + " C degrees and " + humidity + " % humidity");
    }
}
