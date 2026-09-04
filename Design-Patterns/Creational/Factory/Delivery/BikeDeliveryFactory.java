package Creational.Factory.Delivery;

public class BikeDeliveryFactory implements IDeliveryFactory{
    @Override
    public IDeliver getDelivery() {
        return new BikeDelivery();
    }
}
