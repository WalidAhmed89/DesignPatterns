package Behavioral.Interpreter.Calculator;

public class Program {
    public static void main(String[] args) {
        Expression ten = new NumberExpression(10);
        Expression five = new NumberExpression(5);

        Expression addition = new AddExpression(ten,five);
        Expression subtract = new SubtractExpression(ten,five);

        System.out.println(addition.interpret());
        System.out.println(subtract.interpret());
    }
}
