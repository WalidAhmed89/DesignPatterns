package Behavioral.Visitor.BuildingInspectionSystem;

public class Factory implements Building{
    private final String factoryName;
    private final double area;

    public Factory(String factoryName, double area) {
        this.factoryName = factoryName;
        this.area = area;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.factory(this);
    }
}
