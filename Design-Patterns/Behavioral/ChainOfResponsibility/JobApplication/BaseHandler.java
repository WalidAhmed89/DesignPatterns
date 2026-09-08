package Behavioral.ChainOfResponsibility.JobApplication;

public abstract class BaseHandler {
    protected BaseHandler nextHandler;

    public  void setNext(BaseHandler handler){
        nextHandler = handler;
    }

    public abstract void handelRequest(JobApplication request);
}
