package Behavioral.Strategy.DeliveryCostCalculator;

public class SameDayDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double DeliveryCalculator(double distance) {
        return distance * 12 + 50;
    }
}
