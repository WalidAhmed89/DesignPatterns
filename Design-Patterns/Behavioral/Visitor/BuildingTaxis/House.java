package Behavioral.Visitor.BuildingTaxis;

public class House implements Building{
    private final double value;

    public House(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
