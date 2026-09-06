package Structural.Adapter.DistanceCalculator;

public class Program {
    static void main(String[] args) {
        DistanceAdapter distance = new DistanceAdapter();
        System.out.println(distance.calculateDistanceInKilometers(10));
    }
}
