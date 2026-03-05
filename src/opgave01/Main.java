package opgave01;

import opgave01.models.CurrentConditionsDisplay;
import opgave01.models.ForeCastDisplay;
import opgave01.models.StatisticsDisplay;
import opgave01.models.WeatherData;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForeCastDisplay foreCastDisplay = new ForeCastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);


        while (true) {
            weatherData.measurementsChanged();
            Thread.sleep(1000);
        }
    }
}
