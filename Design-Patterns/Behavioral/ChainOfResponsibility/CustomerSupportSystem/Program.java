package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

public class Program {
    public static void main(String[] args) {
        SupportRequest supportRequest1 = new SupportRequest("Walid","password reset",1);
        SupportRequest supportRequest2 = new SupportRequest("Frosted","server issues",2);
        SupportRequest supportRequest3 = new SupportRequest("Omar"," Critical Security Issue",3);

        BasicSupportHandler basicHandler = new BasicSupportHandler();
        TechnicalSupportHandler technicalSupportHandler = new TechnicalSupportHandler();
        ManagerHandler managerHandler = new ManagerHandler();

        basicHandler.setNext(technicalSupportHandler);
        technicalSupportHandler.setNext(managerHandler);
        basicHandler.handleRequest(supportRequest1);
        basicHandler.handleRequest(supportRequest2);
        basicHandler.handleRequest(supportRequest3);
    }
}
