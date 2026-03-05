package opgave01.models;

public class ForeCastDisplay implements WeatherObserver {
    private float previousTemp;
    private float previousHumidity;
    private float previousPressure;

    private float currentTemp;
    private float currentHumidity;
    private float currentPressure;

    private WeatherData weatherData;

    public ForeCastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registrerWeatherObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.previousTemp = this.currentTemp;
        this.previousHumidity = this.currentHumidity;
        this.previousPressure = this.currentPressure;

        this.currentTemp = temp;
        this.currentHumidity = humidity;
        this.currentPressure = pressure;

        display();
    }

    private void display() {
        float forecastTemp = currentTemp + (currentTemp - previousTemp);
        float forecastHumidity = currentHumidity + (currentHumidity - previousHumidity);
        float forecastPressure = currentPressure + (currentPressure - previousPressure);

        System.out.println("Forecast: Next temp = " + forecastTemp +
                ", humidity = " + forecastHumidity +
                ", pressure = " + forecastPressure);
    }
}
