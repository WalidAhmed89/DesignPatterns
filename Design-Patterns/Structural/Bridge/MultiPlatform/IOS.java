package Structural.Bridge.MultiPlatform;

public class IOS implements IOperatingSystem{
    @Override
    public void doOperation() {
        System.out.println("Doing operation on IOS Platform");
    }
}
