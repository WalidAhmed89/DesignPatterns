package Creational_Patterns.Builder.Computer;

public class Program {
    static void main(String[] args) {
        GamingComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingComputerBuilder);
        Computer gamingPC = gamingComputerBuilder.getResult();
        System.out.println(gamingPC.Show());

        System.out.println("--------------------------------------------------");

        OfficeComputerBuilder officeComputerBuilder = new OfficeComputerBuilder();
        ComputerDirector officedirector = new ComputerDirector();
        officedirector.construct(officeComputerBuilder);
        Computer officePC = officeComputerBuilder.getResult();
        System.out.println(officePC.Show());
    }
}
