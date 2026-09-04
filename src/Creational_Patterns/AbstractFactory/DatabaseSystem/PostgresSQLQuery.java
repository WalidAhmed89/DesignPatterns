package Creational_Patterns.AbstractFactory.DatabaseSystem;

public class PostgresSQLQuery implements IQuery{
    @Override
    public String Query() {
        return "Select * from PostgresSQL Where id =?";
    }
}
