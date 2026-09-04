package Creational.Builder.Computer;

public interface IComputerBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGPU();
    void buildOperatingSystem();
    Computer getResult();
}
