package com.thinkgem.jeesite.common.pattern.pattern2;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-04-24 21:24
 */
public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        //推
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);

        //拉
        currentConditionsDisplay.update(weatherData);
        forecastDisplay.update(weatherData);
        statisticsDisplay.update(weatherData);
    }
}
