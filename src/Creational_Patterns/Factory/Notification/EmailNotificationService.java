package Creational_Patterns.Factory.Notification;

public class EmailNotificationService implements INotificationFactory{

    @Override
    public Notification CreatNotificationServece() {
        return new EmailNotification();
    }
}
