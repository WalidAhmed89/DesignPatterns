package Creational.AbstractFactory.Bank;

public class AlAhly_Factory implements IFactory {
    @Override
    public IBank getBank() {
        return new AlAhly_Bank();
    }

    @Override
    public IPaymentCard getPaymentCard() {
        return new VisaCard();
    }
}
