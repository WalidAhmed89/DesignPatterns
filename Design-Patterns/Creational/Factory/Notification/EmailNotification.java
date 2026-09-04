package Creational.Factory.Notification;

public class EmailNotification extends Notification {
    @Override
    public String send(String message) {
        return "This is Email Message: "+message;
    }
}
