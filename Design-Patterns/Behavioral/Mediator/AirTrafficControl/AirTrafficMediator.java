package Behavioral.Mediator.AirTrafficControl;

public interface AirTrafficMediator {
    void requestLanding(Plane plane);
    void notifyPlane(Plane plane,String message);
}
