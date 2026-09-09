package Behavioral.Observer.Poduct;

import Behavioral.Observer.OrderNotficationSystem.CustomerNotification;
import Behavioral.Observer.OrderNotficationSystem.DeliverySystem;
import Behavioral.Observer.OrderNotficationSystem.InventorySystem;
import Behavioral.Observer.OrderNotficationSystem.Order;

public class Program {
    public static void main(String[] args) {
        //CREATING THE OBSERVABLE
        ProductInventory productInventory = new ProductInventory("Laptop",10);

        //CREATING THE OBSERVERS
        Cart cart = new Cart();
        productList productList = new productList();
        Checkout checkout = new Checkout();

        //ADDING THE OBSERVERS INTO THE OBSERVABLE
        productInventory.addProduct(cart);
        productInventory.addProduct(productList);
        productInventory.addProduct(checkout);

        //TEST
        productInventory.setStock(9);

    }
}
