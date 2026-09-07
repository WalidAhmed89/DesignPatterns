package Structural.Facade.ShoppingOrder;

public class SMSNotification {
    public String sendSMS(String toUser,String massage){
        return "this massage is to "+toUser+" the massage is : "+massage;
    }
}
