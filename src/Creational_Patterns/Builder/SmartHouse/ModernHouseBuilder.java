package Creational_Patterns.Builder.SmartHouse;

public class ModernHouseBuilder implements IHouseBuilder{

    House modernHouse;

    public ModernHouseBuilder(){
        modernHouse = new House();
    }

    @Override
    public void buildWalls() {
        modernHouse.Add("Concrete Walls\n");
    }

    @Override
    public void buildRoof() {
        modernHouse.Add("Flat Roof\n");
    }

    @Override
    public void buildDoors() {
        modernHouse.Add("Automatic Doors\n");
    }

    @Override
    public void buildWindows() {
        modernHouse.Add("Large Glass Windows\n");
    }

    @Override
    public void buildGarage() {
        modernHouse.Add("Double Garage\n");
    }

    @Override
    public House getResult() {
        return modernHouse;
    }
}
