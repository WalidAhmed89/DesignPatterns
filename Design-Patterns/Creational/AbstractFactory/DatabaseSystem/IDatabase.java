package Creational.AbstractFactory.DatabaseSystem;

public interface IDatabase {
    IConnection Connection();
    IQuery QUERY();
}
