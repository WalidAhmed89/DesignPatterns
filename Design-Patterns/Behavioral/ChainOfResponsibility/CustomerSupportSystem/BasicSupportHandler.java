package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

public class BasicSupportHandler extends BaseHandler{
    @Override
    public void handleRequest(SupportRequest request) {
        if(request.getPriority() == 1){
            System.out.println("Handled by Basic Support");
            System.out.println("Ended by Basic problem");
            return;
        }
        if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}
