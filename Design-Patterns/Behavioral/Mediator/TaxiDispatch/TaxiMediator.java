package Behavioral.Mediator.TaxiDispatch;

public interface TaxiMediator {
    void requestRide(TaxiDriver driver,String location);
    void sendMessage(TaxiDriver driver,String message);
}
