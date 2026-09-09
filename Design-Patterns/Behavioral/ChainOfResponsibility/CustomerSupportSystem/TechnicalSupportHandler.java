package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

public class TechnicalSupportHandler extends BaseHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if(request.getPriority() == 2){
            System.out.println("Handled by Technical Support");
            System.out.println("Ended by Technical problem");
            return;
        }
        if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}
