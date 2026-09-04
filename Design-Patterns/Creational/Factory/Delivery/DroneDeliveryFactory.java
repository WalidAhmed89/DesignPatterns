package Creational.Factory.Delivery;

public class DroneDeliveryFactory implements IDeliveryFactory{
    @Override
    public IDeliver getDelivery() {
        return new DroneDelivery();
    }
}
