package Behavioral.Mediator.TaxiDispatch;

import java.util.ArrayList;
import java.util.List;

public class TaxiDispatchCenter implements TaxiMediator{

    private final List<TaxiDriver> drivers = new ArrayList<>();

    public void registerDriver(TaxiDriver driver){
        drivers.add(driver);
    }

    @Override
    public void requestRide(TaxiDriver driver, String location) {
        System.out.println("Driver "+driver.getDriverName()+" is request for a ride in : "+location);

        for (TaxiDriver currentDriver : drivers){
            if(currentDriver != driver) {
                currentDriver.receiveMessage(driver.getDriverName() + " is Getting a ride in " + location);
            }
        }
        driver.receiveMessage(driver.getDriverName()+" The Ride is on you now");
    }

    @Override
    public void sendMessage(TaxiDriver driver, String message) {
        driver.receiveMessage(message);
    }
}
