package Structural.Proxy.SMSService;

public abstract class SMSService {
    public abstract String SendSMS(String customerID, String mobile,String sms);
}
