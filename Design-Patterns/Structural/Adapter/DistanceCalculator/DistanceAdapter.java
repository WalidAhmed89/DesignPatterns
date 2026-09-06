package Structural.Adapter.DistanceCalculator;

public class DistanceAdapter implements DistanceCalculator{
    private OldDistanceCalculator oldDistanceCalculator = new OldDistanceCalculator();
    @Override
    public double calculateDistanceInKilometers(double kilometers) {
        double milesCalc = kilometers * 0.621371;
        return oldDistanceCalculator.calculateDistanceInMiles(milesCalc);
    }
}
