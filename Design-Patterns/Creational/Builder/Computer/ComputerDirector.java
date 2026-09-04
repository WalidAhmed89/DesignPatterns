package Creational.Builder.Computer;

public class ComputerDirector {
    IComputerBuilder builder;

    public void construct(IComputerBuilder builder){
        this.builder = builder;
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        builder.buildOperatingSystem();
    }
}
