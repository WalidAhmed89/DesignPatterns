package Behavioral.Visitor.BuildingInspectionSystem;

public class MaintenanceVisitor implements Visitor{
    @Override
    public void house(House house) {
        double tax = house.getArea() * 5;
        System.out.println("House: "+ house.getHouseName()+"\nMaintenance Cost "+tax);
    }

    @Override
    public void factory(Factory factory) {
        double tax = factory.getArea() * 12;
        System.out.println("Factory: "+ factory.getFactoryName()+"\nMaintenance Cost "+tax);
    }

    @Override
    public void hospital(Hospital hospital) {
        double tax = hospital.getArea() * 8;
        System.out.println("Hospital: "+ hospital.getHospitalName()+"\nMaintenance Cost "+tax);
    }
}
