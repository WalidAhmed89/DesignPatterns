package Creational.Builder.SmartHouse;

public class HouseDirector {
    public void construct(IHouseBuilder builder){
       builder.buildWalls();
       builder.buildRoof();
       builder.buildDoors();
       builder.buildWindows();
       builder.buildGarage();
    }
}
