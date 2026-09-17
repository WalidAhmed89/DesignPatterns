package Behavioral.Observer.WeatherStation;

public class PhoneDisplay implements WeatherObserver{
    @Override
    public void update(double temperature) {
        System.out.println("Temp state will be: "+temperature+"For Phone Display");
    }
}
