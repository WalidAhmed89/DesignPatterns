package Structural.Bridge.MultiPlatform;

public class Program {
    static void main(String[] args) {
        //Windows Example
        IOperatingSystem windowsOperatingSystem = new Windows();
        Button windowsButton = new Button(windowsOperatingSystem);
        windowsButton.click();

        //Android Example
        IOperatingSystem androidOperatingSystem = new Android();
        Button androidButton = new Button(androidOperatingSystem);
        androidButton.click();

        //IOS Example
        IOperatingSystem iosOperatingSystem = new IOS();
        Button iosButton = new Button(iosOperatingSystem);
        iosButton.click();
    }
}
