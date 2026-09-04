package Creational.AbstractFactory.UiComponents;

public class WindowsButton implements IButton{
    @Override
    public String createButton() {
        return "Windows Button";
    }
}
