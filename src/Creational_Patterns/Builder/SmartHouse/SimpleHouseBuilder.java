package Creational_Patterns.Builder.SmartHouse;

public class SimpleHouseBuilder implements IHouseBuilder {
    House simplehouse;
    public SimpleHouseBuilder(){
        simplehouse = new House();
    }

    @Override
    public void buildWalls() {
        simplehouse.Add("Brick Walls\n");
    }

    @Override
    public void buildRoof() {
        simplehouse.Add("Normal Roof\n");
    }

    @Override
    public void buildDoors() {
        simplehouse.Add("Wooden Doors\n");
    }

    @Override
    public void buildWindows() {
        simplehouse.Add("Small Windows\n");
    }

    @Override
    public void buildGarage() {
        simplehouse.Add("No Garage\n");
    }

    @Override
    public House getResult() {
        return simplehouse;
    }
}
