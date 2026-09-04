package Creational.Factory.Banking;

public class BankFactory implements IBankFactory {

    @Override
    public IBank GetBank(String BankCode) {
        switch (BankCode){
            case "123456789": return new Bank_AlAhly();
            case "111111111": return new Bank_Misr();
        }
        return null;
    }
}
