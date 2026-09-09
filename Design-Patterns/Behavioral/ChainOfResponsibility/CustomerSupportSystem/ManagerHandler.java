package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

public class ManagerHandler extends BaseHandler{
    @Override
    public void handleRequest(SupportRequest request) {
        if(request.getPriority() == 3){
            System.out.println("Handled by Manager Support");
            System.out.println("Ended by Manager problem");
            return;
        }
        if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}
