package Structural.Proxy.SMSService;

public class Program {
    static void main(String[] args) {
        SMSServiceProxy sms = new SMSServiceProxy();
        System.out.println(sms.SendSMS("212007","01158596745","Hi am Walid Ahmed"));
        System.out.println(sms.SendSMS("212007","01158342745","Hi am Frosted"));
        System.out.println(sms.SendSMS("212007","011585922745","Hi am someone"));
        System.out.println(sms.SendSMS("546523","011585922745","Hi am someone"));
    }
}
