package Structural.Proxy.SMSService;

import java.util.Hashtable;
import java.util.Map;

public class SMSServiceProxy {

    //TODO: Count calls for each customer,if calls >>2 don't send sms
    private SMSService _smsService;
    private final Map<String, Integer> sentCount = new Hashtable<>();

    public String SendSMS(String customerID,String mobile,String sms){
        //First call
        if(_smsService == null){
            _smsService = new ConceerteSMSService();
        }
        // Customer doesn't exist
        if(!sentCount.containsKey(customerID)){
            sentCount.put(customerID,1);
            return _smsService.SendSMS(customerID,mobile,sms);
        }
        // Customer already exists
        int count = sentCount.get(customerID);

        // Limit reached
        if(count >= 2){
            return "SMS limit Exceeded";
        }
        //Increment count
        sentCount.put(customerID,count+1);
        return _smsService.SendSMS(customerID,mobile,sms);
    }
}
