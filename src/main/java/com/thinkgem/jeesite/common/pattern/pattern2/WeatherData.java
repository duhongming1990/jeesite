package com.thinkgem.jeesite.common.pattern.pattern2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-04-24 20:59
 */
@AllArgsConstructor
@Setter
@Getter
public class WeatherData implements Subject {
    private List<Observer> observers;

    private float temperature;
    private float humidity;
    private float pressure;

    private CurrentConditionsDisplay currentConditionsDisplay;
    private ForecastDisplay forecastDisplay;
    private StatisticsDisplay statisticsDisplay;

    public WeatherData() {
        observers = new LinkedList<>();
    }

    public void measurementsChanged() {
        //改变的地方需要封装起来
//        currentConditionsDisplay.update(temperature,humidity,pressure);
//        forecastDisplay.update(temperature,humidity,pressure);
//        statisticsDisplay.update(temperature,humidity,pressure);
        notifyObservers();

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(temperature, humidity, pressure));
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
