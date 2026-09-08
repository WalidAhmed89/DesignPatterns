package Behavioral.ChainOfResponsibility.JobApplication.FirstScenario;

import Behavioral.ChainOfResponsibility.JobApplication.BaseHandler;
import Behavioral.ChainOfResponsibility.JobApplication.JobApplication;

public class TechHandler extends BaseHandler {
    @Override
    public void handelRequest(JobApplication request) {
        if (request.getJobTitle().equals("AI Engineer") || request.getJobTitle().equals("Backend Engineer")) {
            request.getComments().append("Managed by Tech\n");
        }
        if(nextHandler != null){
            nextHandler.handelRequest(request);
        }else{
            request.getComments().append("End by Tech");
        }
    }
}
