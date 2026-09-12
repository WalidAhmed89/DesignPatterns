package Behavioral.Visitor.BuildingInspectionSystem;

public interface Building {
    void accept(Visitor visitor);
}
