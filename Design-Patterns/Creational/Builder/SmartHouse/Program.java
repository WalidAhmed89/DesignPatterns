package Creational.Builder.SmartHouse;

public class Program {
    static void main(String[] args) {
        IHouseBuilder ModernBuilder = new ModernHouseBuilder();
        HouseDirector ModernDirector = new HouseDirector();
        ModernDirector.construct(ModernBuilder);
        House Modernhouse = ModernBuilder.getResult();
        System.out.println(Modernhouse.Show());

        System.out.println("---------------------------");

        IHouseBuilder SimpleBuilder = new SimpleHouseBuilder();
        HouseDirector SimpleDirector = new HouseDirector();
        SimpleDirector.construct(SimpleBuilder);
        House Simplehouse = SimpleBuilder.getResult();
        System.out.println(Simplehouse.Show());
    }
}
