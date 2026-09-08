package Behavioral.ChainOfResponsibility.JobApplication.SecondScenario;

import Behavioral.ChainOfResponsibility.JobApplication.BaseHandler;
import Behavioral.ChainOfResponsibility.JobApplication.JobApplication;

public class HRHandler extends BaseHandler {

    @Override
    public void handelRequest(JobApplication request) {
        if (request.getJobTitle().equals("Product Management") || request.getJobTitle().equals("Sales")) {
            request.getComments().append("Managed by HR\n");
            return;
        }
        if(nextHandler != null){
            nextHandler.handelRequest(request);
        }
    }
}
