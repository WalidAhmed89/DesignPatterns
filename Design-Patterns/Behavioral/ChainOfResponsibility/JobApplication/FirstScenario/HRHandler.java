package Behavioral.ChainOfResponsibility.JobApplication.FirstScenario;

import Behavioral.ChainOfResponsibility.JobApplication.BaseHandler;
import Behavioral.ChainOfResponsibility.JobApplication.JobApplication;

public class HRHandler extends BaseHandler {
    @Override
    public void handelRequest(JobApplication request) {
        if (request.getJobTitle().equals("Product Management") || request.getJobTitle().equals("Sales")) {
            request.getComments().append("Managed by HR\n");
        }
        if(nextHandler != null){
            nextHandler.handelRequest(request);
        }else{
            request.getComments().append("End by HR");
        }
    }
}
