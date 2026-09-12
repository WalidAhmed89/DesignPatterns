package Behavioral.Visitor.BuildingInspectionSystem;

public class House implements Building{
    private final String houseName;
    private final double area;

    public House(String houseName, double area) {
        this.houseName = houseName;
        this.area = area;
    }

    public String getHouseName() {
        return houseName;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.house(this);
    }
}
