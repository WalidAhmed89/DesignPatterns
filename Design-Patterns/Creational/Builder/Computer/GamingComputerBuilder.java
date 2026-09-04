package Creational.Builder.Computer;

public class GamingComputerBuilder implements IComputerBuilder {

    private Computer Gaming_PC;
    public GamingComputerBuilder(){
        Gaming_PC = new Computer();
    }

    @Override
    public void buildCPU() {
        Gaming_PC.Add("Ryzen 7 \n");
    }

    @Override
    public void buildRAM() {
        Gaming_PC.Add("32GB \n");
    }

    @Override
    public void buildStorage() {
        Gaming_PC.Add("1TB NVMe \n");
    }

    @Override
    public void buildGPU() {
        Gaming_PC.Add("RTX4070 \n");
    }

    @Override
    public void buildOperatingSystem() {
        Gaming_PC.Add("Windows \n");
    }

    @Override
    public Computer getResult() {
        return Gaming_PC;
    }
}
