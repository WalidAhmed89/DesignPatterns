package Structural.Decorator.SMSServiceDecorator;

import Structural.Proxy.SMSService.SMSService;

public abstract class SMSDecorator extends SMSService {
    SMSService notificationService;

    public void setService(SMSService service){
        notificationService = service;
    }
    @Override
    public String SendSMS(String customerID, String mobile,String sms){
        if(notificationService != null){
            return notificationService.SendSMS(customerID,mobile,sms);
        }
        return "Notification service not initialized!";
    }
}
