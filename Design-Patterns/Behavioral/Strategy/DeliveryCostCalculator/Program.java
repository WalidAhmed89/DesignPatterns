package Behavioral.Strategy.DeliveryCostCalculator;

public class Program {
    public static void main(String[] args) {
        DeliveryCalculator calculator = new DeliveryCalculator();

        calculator.setStrategy(new StandardDeliveryStrategy());
        System.out.println(calculator.calculateCost(10));

        calculator.setStrategy(new ExpressDeliveryStrategy());
        System.out.println(calculator.calculateCost(10));

        calculator.setStrategy(new SameDayDeliveryStrategy());
        System.out.println(calculator.calculateCost(10));
    }
}
