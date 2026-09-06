package Structural.Decorator.SMSServiceDecorator;

import Structural.Proxy.SMSService.ConceerteSMSService;

public class Program {
    static void main(String[] args) {
        ConceerteSMSService smsService = new ConceerteSMSService();
        NotificationEmailDecorator emailDecorator = new NotificationEmailDecorator();

        emailDecorator.setService(smsService);
        System.out.println(emailDecorator.SendSMS("123","01158596745","hi"));
    }
}
