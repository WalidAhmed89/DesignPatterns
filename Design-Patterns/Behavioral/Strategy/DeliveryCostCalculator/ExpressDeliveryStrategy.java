package Behavioral.Strategy.DeliveryCostCalculator;

public class ExpressDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double DeliveryCalculator(double distance) {
        return distance * 8 + 30;
    }
}
