package Creational_Patterns.AbstractFactory.Bank;

public interface IFactory {
    IBank getBank();
    IPaymentCard getPaymentCard();
}
