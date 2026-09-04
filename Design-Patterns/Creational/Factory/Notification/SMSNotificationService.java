package Creational.Factory.Notification;

public class SMSNotificationService implements INotificationFactory{
    @Override
    public Notification CreatNotificationServece() {
        return new SMSNotification();
    }
}
