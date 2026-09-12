package Behavioral.TemplateMethod.PizzaMaker;

public class Program {
    public static void main(String[] args) {
        PizzaMaker chickenPizza = new ChickenPizza();
        chickenPizza.makePizza();

        System.out.println("\n----------------\n");

        PizzaMaker cheesePizza = new CheesePizza();
        cheesePizza.makePizza();
    }
}
