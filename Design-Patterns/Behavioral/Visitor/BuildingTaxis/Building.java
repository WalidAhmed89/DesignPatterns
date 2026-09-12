package Behavioral.Visitor.BuildingTaxis;

public interface Building {
    void accept(Visitor visitor);
}
