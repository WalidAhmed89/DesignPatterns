package Behavioral.State.PaymentSystem;

public class Payment {
    private PaymentState state;

    public Payment(){
        this.state = new PendingState();
    }

    public void setState(PaymentState state){
        this.state = state;
    }

    public void pay(){
        state.pay(this);
    }

    public void ship(){
        state.ship(this);
    }

    public void complete(){
        state.complete(this);
    }
}
