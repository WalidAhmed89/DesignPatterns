package Creational_Patterns.Singleton.Login;

public class Program {
    static void main(String[] args) {
        //Bad Version
        LoginCounter_FirstVersion user1 = new LoginCounter_FirstVersion();
        LoginCounter_FirstVersion user2 = new LoginCounter_FirstVersion();

        user1.loginCounter();
        user2.loginCounter();

        System.out.println("Bad Version");
        System.out.println("User1: " + user1.Counter);
        System.out.println("User2: " + user2.Counter);

        //Creational_Patterns.Singleton Version
        LoginCounter_Singlton user3 = LoginCounter_Singlton.getInstance();
        LoginCounter_Singlton user4 = LoginCounter_Singlton.getInstance();
        user3.loginCounter();
        user4.loginCounter();

        System.out.println("Creational_Patterns.Singleton Version");
        System.out.println("User3: " + user3.Counter);
        System.out.println("User4: " + user4.Counter);


    }
}
