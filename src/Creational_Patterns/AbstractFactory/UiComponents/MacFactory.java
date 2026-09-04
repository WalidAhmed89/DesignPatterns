package Creational_Patterns.AbstractFactory.UiComponents;

public class MacFactory implements IGUIFactory{
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ICheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
