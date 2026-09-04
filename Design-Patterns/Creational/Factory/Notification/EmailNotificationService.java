package Creational.Factory.Notification;

public class EmailNotificationService implements INotificationFactory{

    @Override
    public Notification CreatNotificationServece() {
        return new EmailNotification();
    }
}
