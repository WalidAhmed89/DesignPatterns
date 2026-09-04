package Creational.Factory.Banking;

public interface IBankFactory {
    IBank GetBank(String BankCode);
}
