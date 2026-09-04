package Creational_Patterns.Factory.Banking;

public class Bank_AlAhly implements IBank {
    @Override
    public String Withdraw() {
        return "Your request is handling by AlBank-AlAhly";
    }
}
