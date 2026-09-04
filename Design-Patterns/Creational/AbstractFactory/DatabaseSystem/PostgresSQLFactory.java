package Creational.AbstractFactory.DatabaseSystem;

public class PostgresSQLFactory implements IDatabase{
    @Override
    public IConnection Connection() {
        return new PostgresSQLConnection();
    }

    @Override
    public IQuery QUERY() {
        return new PostgresSQLQuery();
    }
}
