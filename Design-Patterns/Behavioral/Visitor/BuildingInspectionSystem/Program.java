package Behavioral.Visitor.BuildingInspectionSystem;

public class Program {
    public static void main(String[] args) {
        Building house = new House("Walid House",200);
        Building factory = new Factory("Tech Factory",1000);
        Building hospital = new Hospital("City Hospital",500);

        MaintenanceVisitor visitor = new MaintenanceVisitor();

        house.accept(visitor);
        factory.accept(visitor);
        hospital.accept(visitor);
    }
}
