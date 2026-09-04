package Creational_Patterns.AbstractFactory.DatabaseSystem;

public class MySQLConnection implements IConnection{
    @Override
    public String ConnectionURL() {
        return "MySQL@Database";
    }

    @Override
    public String ConnectionPassword() {
        return "MySQL123";
    }
}
