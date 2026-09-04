package Creational.AbstractFactory.DatabaseSystem;

public class PostgresSQLConnection implements IConnection{

    @Override
    public String ConnectionURL() {
        return "PostgresSQL@Database";
    }

    @Override
    public String ConnectionPassword() {
        return "PostgresSQL123";
    }
}
