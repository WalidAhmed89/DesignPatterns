package Creational_Patterns.Factory.Notification;

public class PushNotficationService implements INotificationFactory{
    @Override
    public Notification CreatNotificationServece() {
        return new PushNotification();
    }
}
