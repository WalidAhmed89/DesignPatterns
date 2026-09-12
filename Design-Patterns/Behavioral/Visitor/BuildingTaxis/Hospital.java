package Behavioral.Visitor.BuildingTaxis;

public class Hospital implements Building{
    private final double value;

    public Hospital(double value) {
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
