package Creational_Patterns.Factory.Banking;

public interface IBankFactory {
    IBank GetBank(String BankCode);
}
