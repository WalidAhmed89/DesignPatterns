package Structural.Facade;

public class PurchaseOrder {
     public boolean createOrder(ShoppingBasket basket,String customerInfo){
         //Check Stock
         boolean isAvailable = true;
         Inventory inventory = new Inventory();
         for(BasketItem item : basket.getItems()){
             if(!inventory.checkItemQuantity(item.getItemID(),item.getQuantity())){
                 isAvailable = false;
             }
         }
         if(isAvailable){
             //Create inventory order
             InventoryOrder inventoryOrder = new InventoryOrder();
             inventoryOrder.createOrder(basket);

             //create invoice
             PurchaseInvoice invoice = new PurchaseInvoice();
             PurchaseInvoice inv = invoice.createInvoce(basket,"address:123,id:7272,email:walid@gmail.com");

             //Payment
             PaymentProcessor payment = new PaymentProcessor();
             payment.handlePayment(inv.netTotal,"acc=734982");

             //Send SMS
             SMSNotification sms = new SMSNotification();
             sms.sendSMS("Frosted","invoice Created");
             return true;
         }

         return false;
     }
}
