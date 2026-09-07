package Structural.Facade;

public class Inventory {
    public boolean checkItemQuantity(String itemID,double quantity){
        return quantity < 100;
    }
}
