package Structural.Bridge.MultiPlatform;

public interface ICommonUI {
    IOperatingSystem getOperatingSystem();
    void setOperatingSystem(IOperatingSystem operatingSystem);

    void click();
}
