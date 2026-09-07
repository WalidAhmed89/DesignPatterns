package Structural.Facade;

public class BasketItem {
    private String itemID;
    private double itemPrice;
    private int quantity;

    public BasketItem(String itemID,double itemPrice,int quantity){
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
