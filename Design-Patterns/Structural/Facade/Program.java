package Structural.Facade;

public class Program {
    static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new BasketItem("82828",999,3));
        basket.addItem(new BasketItem("23232",444,1));
        basket.addItem(new BasketItem("9767",1000,4));
        PurchaseOrder purchase = new PurchaseOrder();
        purchase.createOrder(basket,"Name: Walid Ahmed Ismail, bank:4985493, mobile:01158596745");
    }
}
