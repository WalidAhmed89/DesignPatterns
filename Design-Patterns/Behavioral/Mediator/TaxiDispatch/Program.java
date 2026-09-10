package Behavioral.Mediator.TaxiDispatch;

public class Program {
    public static void main(String[] args) {
        TaxiDispatchCenter dispatchCenter = new TaxiDispatchCenter();

        TaxiDriver driver1 = new TaxiDriver("Ahmed",dispatchCenter);
        TaxiDriver driver2 = new TaxiDriver("Walid",dispatchCenter);
        TaxiDriver driver3 = new TaxiDriver("Mohamed",dispatchCenter);

        dispatchCenter.registerDriver(driver1);
        dispatchCenter.registerDriver(driver2);
        dispatchCenter.registerDriver(driver3);

       driver1.requestRide("Nasr City");
    }
}
