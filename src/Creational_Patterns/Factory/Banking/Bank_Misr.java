package Creational_Patterns.Factory.Banking;

public class Bank_Misr implements IBank {
    @Override
    public String Withdraw() {
        return "Your request is handling by AlBank-Almisry";
    }
}
