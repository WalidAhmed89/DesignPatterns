package Creational.Factory.Banking;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        BankFactory bankFactory = new BankFactory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your bank code");
        String BankCode = sc.next();
        IBank bank = bankFactory.GetBank(BankCode);
        System.out.println(bank.Withdraw());
    }
}
