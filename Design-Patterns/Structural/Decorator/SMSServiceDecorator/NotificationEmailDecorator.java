package Structural.Decorator.SMSServiceDecorator;

import java.time.LocalDateTime;

public class NotificationEmailDecorator extends SMSDecorator {

    public String smsSentNotificationToEmail(String customerID,String sms){
        return "sms: "+sms+" , sent to "+customerID+" at "+ LocalDateTime.now();
    }

    @Override
    public String SendSMS(String customerID, String mobile, String sms) {
        StringBuilder result = new StringBuilder();
        result.append(super.SendSMS(customerID, mobile, sms)).append("\n");
        result.append(smsSentNotificationToEmail(customerID, sms)).append("\n");

        return result.toString();
    }
}
