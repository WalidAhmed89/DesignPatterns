package Creational_Patterns.AbstractFactory.DatabaseSystem;

public class MySQLQuery implements IQuery{
    @Override
    public String Query() {
        return "Select * from MySQl Where id =?";
    }
}
