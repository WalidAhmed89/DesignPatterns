package Creational_Patterns.Singleton.Connection;

public class DatabaseConnection {
    String ConnectionURL ;
    String ConnectionPassword;

    private DatabaseConnection(String ConnectionURL,String ConnectionPassword){
        this.ConnectionURL = ConnectionURL;
        this.ConnectionPassword = ConnectionPassword;
    }

    private static DatabaseConnection instance = null;

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection("FrostedDatabase","Frosted2111");
        }
        return instance;
    }

}
