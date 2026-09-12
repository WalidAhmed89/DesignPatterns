package Behavioral.Visitor.BuildingTaxis;

public class Factory implements Building{
    private final double value;

    public Factory(double value) {
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
