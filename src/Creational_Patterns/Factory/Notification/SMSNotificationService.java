package Creational_Patterns.Factory.Notification;

public class SMSNotificationService implements INotificationFactory{
    @Override
    public Notification CreatNotificationServece() {
        return new SMSNotification();
    }
}
