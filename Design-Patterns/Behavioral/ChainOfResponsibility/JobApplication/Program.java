package Behavioral.ChainOfResponsibility.JobApplication;

import Behavioral.ChainOfResponsibility.JobApplication.SecondScenario.HRHandler;
import Behavioral.ChainOfResponsibility.JobApplication.SecondScenario.TechHandler;

public class Program {
    public static void main(String[] args) {
        JobApplication jobApplication = new JobApplication("Walid Ahmed","Backend Engineer","9543532",new StringBuilder());
        //First Review
        HRHandler hrReview1 = new HRHandler();
        TechHandler techReview1 = new TechHandler();

        hrReview1.setNext(techReview1);
        hrReview1.handelRequest(jobApplication);
        System.out.println(jobApplication.showComments());
    }
}
