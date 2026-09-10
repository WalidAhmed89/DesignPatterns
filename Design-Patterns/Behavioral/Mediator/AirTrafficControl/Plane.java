package Behavioral.Mediator.AirTrafficControl;

public class Plane {
    private final String name;
    private final AirTrafficMediator mediator;


    public Plane(String name, AirTrafficMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void requestLanding(){
        System.out.println(name+" Requesting landing...");
        mediator.requestLanding(this);
    }

    public void receiveMessage(String message){
        System.out.println(name+ " "+message);
    }
}
