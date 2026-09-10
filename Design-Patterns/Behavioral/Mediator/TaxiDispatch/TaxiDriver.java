package Behavioral.Mediator.TaxiDispatch;

public class TaxiDriver {
    private final String driverName;
    private final TaxiMediator mediator;


    public TaxiDriver(String driverName, TaxiMediator mediator) {
        this.driverName = driverName;
        this.mediator = mediator;
    }

    public String getDriverName() {
        return driverName;
    }

    public void requestRide(String location){
        System.out.println(driverName+" Requesting for Ride");
        mediator.requestRide(this,location);
    }

    public void receiveMessage(String message){
        System.out.println(this.driverName+" "+message);
    }
}
