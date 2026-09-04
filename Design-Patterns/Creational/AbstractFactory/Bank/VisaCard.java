package Creational.AbstractFactory.Bank;

public class VisaCard implements IPaymentCard {
    @Override
    public String getCard() {
        return "Visa Card";
    }
}
