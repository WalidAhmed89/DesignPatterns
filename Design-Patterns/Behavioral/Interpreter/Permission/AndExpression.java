package Behavioral.Interpreter.Permission;

public class AndExpression implements Expression{
    private final Expression firstExpression;
    private final Expression secondExpression;

    public AndExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }


    @Override
    public boolean interpreter() {
        return firstExpression.interpreter() && secondExpression.interpreter();
    }
}
