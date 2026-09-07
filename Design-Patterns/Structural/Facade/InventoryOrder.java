package Structural.Facade;

public class InventoryOrder {

    public String createOrder(ShoppingBasket basket){
        basket.getItems();
        return "Order number is: "+System.identityHashCode(basket);
    }
}
