package Creational_Patterns.Factory.Delivery;

public class CarDeliveryFactory implements IDeliveryFactory{
    @Override
    public IDeliver getDelivery() {
        return new CarDelivery();
    }
}
