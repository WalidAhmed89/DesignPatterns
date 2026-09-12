package Behavioral.Visitor.BuildingTaxis;

public interface Visitor {
    void visit(House house);
    void visit(Factory factory);
    void visit(Hospital hospital);
}
