package Creational.Builder.ProductBuilder;

public class Program {
    static void main(String[] args) {
        //making a car
        Director directorCar = new Director();
        IBuilder carBuilder = new Car("BMW");

        directorCar.Construct(carBuilder);
        Product car = carBuilder.GetVehicle();
        System.out.println(car.Show());

        //Making a Motorcycle
        Director directorMotorcycle = new Director();
        IBuilder MotorcycleBuilder = new MotorCycle("Yamaha r1");

        directorMotorcycle.Construct(MotorcycleBuilder);
        Product Motorcycle = MotorcycleBuilder.GetVehicle();
        System.out.println(Motorcycle.Show());
    }
}
