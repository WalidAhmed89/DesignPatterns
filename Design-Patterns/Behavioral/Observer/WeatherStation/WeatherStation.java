package Behavioral.Observer.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherSubject{
    private List<WeatherObserver> observerList;
    private int temperature;

    public WeatherStation(int temperature) {
        this.observerList = new ArrayList<>();
        this.temperature = temperature;
    }


    @Override
    public void addObserver(WeatherObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(WeatherObserver observer : observerList){
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;

    }
}
