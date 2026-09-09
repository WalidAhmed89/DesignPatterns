package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SupportRequest {
    private String customerName;
    private String issue;
    private int priority;


    public SupportRequest(String customerName, String issue,int priority) {
        this.customerName = customerName;
        this.issue = issue;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }


}
