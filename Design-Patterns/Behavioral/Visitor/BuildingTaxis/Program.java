package Behavioral.Visitor.BuildingTaxis;

public class Program {
    public static void main(String[] args) {
        Building house = new House(100000);
        Building factory = new Factory(500000);
        Building hospital = new Hospital(300000);

        Visitor taxVisitor = new TaxVistor();

        house.accept(taxVisitor);
        factory.accept(taxVisitor);
        hospital.accept(taxVisitor);
    }
}
