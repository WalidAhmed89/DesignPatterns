package Behavioral.Mediator.AirTrafficControl;

public class Program {
    static void main(String[] args) {

        AirTrafficControl control = new AirTrafficControl();

        Plane planeA = new Plane("Plane A", control);
        Plane planeB = new Plane("Plane B", control);
        Plane planeC = new Plane("Plane C", control);

        control.registerPlane(planeA);
        control.registerPlane(planeB);
        control.registerPlane(planeC);

        planeA.requestLanding();
    }
}
