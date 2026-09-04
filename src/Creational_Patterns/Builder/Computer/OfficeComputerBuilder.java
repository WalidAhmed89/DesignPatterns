package Creational_Patterns.Builder.Computer;

public class OfficeComputerBuilder implements IComputerBuilder {

    private Computer PC;
    public OfficeComputerBuilder(){
        PC = new Computer();
    }

    @Override
    public void buildCPU() {
        PC.Add("Intel i5 \n");
    }

    @Override
    public void buildRAM() {
        PC.Add("16GB \n");
    }

    @Override
    public void buildStorage() {
        PC.Add("512GB SSD \n");
    }

    @Override
    public void buildGPU() {
        PC.Add("Integrated Graphics \n");
    }

    @Override
    public void buildOperatingSystem() {
        PC.Add("Windows \n");
    }

    @Override
    public Computer getResult() {
        return PC;
    }
}
