package Behavioral.Strategy.DeliveryCostCalculator;

public class StandardDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double DeliveryCalculator(double distance) {
        return distance * 5;
    }
}
