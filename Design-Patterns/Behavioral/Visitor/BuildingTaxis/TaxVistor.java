package Behavioral.Visitor.BuildingTaxis;

public class TaxVistor implements Visitor{
    @Override
    public void visit(House house) {
        double tax = house.getValue() * 0.05;
        System.out.println("House tax "+tax);
    }

    @Override
    public void visit(Factory factory) {
        double tax = factory.getValue() * 0.10;
        System.out.println("House tax "+tax);
    }

    @Override
    public void visit(Hospital hospital) {
        double tax = hospital.getValue() * 0.03;
        System.out.println("House tax "+tax);
    }
}
