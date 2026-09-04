package Creational.Factory.Notification;

public class PushNotification extends Notification {
    @Override
    public String send(String message) {
        return "This is Push Message: "+message;
    }
}
