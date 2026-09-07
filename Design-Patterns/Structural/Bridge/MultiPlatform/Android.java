package Structural.Bridge.MultiPlatform;

public class Android implements IOperatingSystem{
    @Override
    public void doOperation() {
        System.out.println("Doing operation on Android Platform");
    }
}
