package Behavioral.TemplateMethod.OnlineOrderProcessing;

public class Program {
    public static void main(String[] args) {
        OrderProcessor creditOrder = new CreditCardOrder();
        creditOrder.orderProcessor();

        System.out.println("\n--------------\n");

        OrderProcessor cashOrder = new CashOnDeliveryOrder();
        cashOrder.orderProcessor();
    }
}
