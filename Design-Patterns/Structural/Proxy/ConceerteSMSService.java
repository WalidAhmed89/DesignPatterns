package Structural.Proxy;

public class ConceerteSMSService extends SMSService{
    @Override
    public String SendSMS(String customerID, String mobile, String sms) {
        return "Customer ID: "+customerID+" SMS: "+sms;
    }
}
