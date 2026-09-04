package Creational.AbstractFactory.Bank;

public class MasterCard implements IPaymentCard {
    @Override
    public String getCard() {
        return "Master Card";
    }
}
