package Behavioral.Strategy.DeliveryCostCalculator;

public class DeliveryCalculator {

    private DeliveryStrategy strategy;

    public void setStrategy (DeliveryStrategy strategy){
        this.strategy = strategy;
    }

    public double calculateCost(double distance){
        return strategy.DeliveryCalculator(distance);
    }
}
