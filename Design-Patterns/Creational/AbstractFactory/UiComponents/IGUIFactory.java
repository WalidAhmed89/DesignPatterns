package Creational.AbstractFactory.UiComponents;

public interface IGUIFactory {
    IButton createButton();
    ICheckBox createCheckBox();
}
