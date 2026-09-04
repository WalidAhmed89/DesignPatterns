package Creational_Patterns.Singleton.Login;

public class LoginCounter_Singlton {
    int Counter = 0;

    private LoginCounter_Singlton() {
    }

    private static LoginCounter_Singlton instance = null;


    public static LoginCounter_Singlton getInstance() {
        if (instance == null) {
            instance = new LoginCounter_Singlton();
        }
        return instance;
    }

    public void loginCounter() {
        Counter++;
    }
}
