package Behavioral.Visitor.BuildingInspectionSystem;

public interface Visitor {
    void house(House house);
    void factory(Factory factory);
    void hospital(Hospital hospital);
}
