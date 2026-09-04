package Creational_Patterns.AbstractFactory.UiComponents;

public class WindowsFactory implements IGUIFactory{
    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ICheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
