package Behavioral.Visitor.BuildingInspectionSystem;

public class Hospital implements Building{
    private final String hospitalName;
    private final double area;

    public Hospital(String hospitalName, double area) {
        this.hospitalName = hospitalName;
        this.area = area;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.hospital(this);
    }
}
