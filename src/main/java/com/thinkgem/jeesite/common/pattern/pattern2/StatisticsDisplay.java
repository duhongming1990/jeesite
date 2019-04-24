package com.thinkgem.jeesite.common.pattern.pattern2;

import lombok.ToString;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-04-24 21:04
 */
@ToString
public class StatisticsDisplay implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public StatisticsDisplay(Subject weatherData){
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void update(Subject subject){
        if(subject instanceof WeatherData){
            weatherData = (WeatherData)subject;
        }
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        display();
    }

    @Override
    public void display() {
        System.out.println("StatisticsDisplay = " + toString());
    }

}
