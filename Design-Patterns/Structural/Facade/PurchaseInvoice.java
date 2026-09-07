package Structural.Facade;

import java.util.List;

public class PurchaseInvoice {
    double discount = 0;
    double totalAmount = 0;
    double netTotal = 0;

    public PurchaseInvoice createInvoce(ShoppingBasket basket,String customerInfo){
        PurchaseInvoice invoice = new PurchaseInvoice();
        List<BasketItem> items = basket.getItems();
        for (BasketItem item : items){
            invoice.totalAmount += item.getItemPrice() * item.getQuantity();
        }
        if(items.size() >5){
            invoice.discount = 20;
        }
        invoice.totalAmount = invoice.totalAmount - invoice.discount;
        return invoice;
    }
}
