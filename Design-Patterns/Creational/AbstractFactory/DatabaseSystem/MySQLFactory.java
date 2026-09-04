package Creational.AbstractFactory.DatabaseSystem;

public class MySQLFactory implements IDatabase{
    @Override
    public IConnection Connection() {
        return new MySQLConnection();
    }

    @Override
    public IQuery QUERY() {
        return new MySQLQuery();
    }
}
