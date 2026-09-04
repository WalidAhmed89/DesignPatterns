package Creational.Factory.Notification;

public class SMSNotification extends Notification {
    @Override
    public String send(String message) {
        return "This is SMS Message: "+message;
    }
}
