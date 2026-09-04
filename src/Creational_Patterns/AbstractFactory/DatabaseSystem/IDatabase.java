package Creational_Patterns.AbstractFactory.DatabaseSystem;

public interface IDatabase {
    IConnection Connection();
    IQuery QUERY();
}
