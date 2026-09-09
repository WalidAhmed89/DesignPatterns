package Behavioral.ChainOfResponsibility.CustomerSupportSystem;

public abstract class BaseHandler {
    protected BaseHandler nextHandler;

    public void setNext(BaseHandler handler){
        nextHandler = handler;
    }

    public abstract void handleRequest(SupportRequest request);
}
