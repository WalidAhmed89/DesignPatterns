package Behavioral.Mediator.AirTrafficControl;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficControl implements AirTrafficMediator{
    private final List<Plane> planes = new ArrayList<>();

    public void registerPlane(Plane plane){
        planes.add(plane);
    }

    @Override
    public void requestLanding(Plane plane) {
        System.out.println("Control Tower: "+plane.getName()+" is requesting landing");

        for (Plane currentPlane : planes){
            if(currentPlane != plane){
                currentPlane.receiveMessage(plane.getName() + " is landing now.");
            }
        }
        plane.receiveMessage("Landing approved.");
    }

    @Override
    public void notifyPlane(Plane plane, String message) {
        plane.receiveMessage(message);
    }
}
