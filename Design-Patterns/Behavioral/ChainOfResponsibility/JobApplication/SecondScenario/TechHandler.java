package Behavioral.ChainOfResponsibility.JobApplication.SecondScenario;

import Behavioral.ChainOfResponsibility.JobApplication.BaseHandler;
import Behavioral.ChainOfResponsibility.JobApplication.JobApplication;

public class TechHandler extends BaseHandler {
    @Override
    public void handelRequest(JobApplication request) {
        if (request.getJobTitle().equals("Backend Engineer") || request.getJobTitle().equals("Software Engineer") || request.getJobTitle().equals("AI Engineer")) {
            request.getComments().append("Managed by Tech\n");
            return;
        }
        if (nextHandler != null) {
            nextHandler.handelRequest(request);
        }
    }
}
