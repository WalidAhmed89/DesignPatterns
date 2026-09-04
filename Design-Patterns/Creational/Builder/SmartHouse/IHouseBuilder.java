package Creational.Builder.SmartHouse;

public interface IHouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildDoors();
    void buildWindows();
    void buildGarage();
    House getResult();
}
