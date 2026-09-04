package Creational.AbstractFactory.DatabaseSystem;

public class MySQLQuery implements IQuery{
    @Override
    public String Query() {
        return "Select * from MySQl Where id =?";
    }
}
