package Creational_Patterns.AbstractFactory.UiComponents;

public interface IGUIFactory {
    IButton createButton();
    ICheckBox createCheckBox();
}
