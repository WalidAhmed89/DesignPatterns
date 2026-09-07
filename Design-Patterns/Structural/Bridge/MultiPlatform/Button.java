package Structural.Bridge.MultiPlatform;

public class Button implements ICommonUI{

    private IOperatingSystem operatingSystem;
    public Button(IOperatingSystem operatingSystem){
        this.operatingSystem = operatingSystem;
    }
    @Override
    public IOperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public void setOperatingSystem(IOperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void click() {
         operatingSystem.doOperation();
    }
}
