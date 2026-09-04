package Creational.AbstractFactory.Bank;

public interface IFactory {
    IBank getBank();
    IPaymentCard getPaymentCard();
}
