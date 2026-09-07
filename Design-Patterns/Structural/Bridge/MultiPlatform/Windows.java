package Structural.Bridge.MultiPlatform;

public class Windows implements IOperatingSystem{
    @Override
    public void doOperation() {
        System.out.println("Doing operation on Windows Platform");
    }
}
