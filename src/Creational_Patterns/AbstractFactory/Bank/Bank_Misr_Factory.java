package Creational_Patterns.AbstractFactory.Bank;

public class Bank_Misr_Factory implements IFactory {
    @Override
    public IBank getBank() {
        return new Bank_Misr();
    }

    @Override
    public IPaymentCard getPaymentCard() {
        return new MasterCard();
    }
}
