package Behavioral.Observer.WeatherStation;

public class TVDisplay implements WeatherObserver{
    @Override
    public void update(double temperature) {
        System.out.println("Temp state will be: "+temperature+"For TV Display");
    }
}
