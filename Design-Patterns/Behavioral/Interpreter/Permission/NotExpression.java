package Behavioral.Interpreter.Permission;

public class NotExpression implements Expression{
    private final Expression expression;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }


    @Override
    public boolean interpreter() {
        if(!expression.interpreter()){
            return true;
        }
        return false;
    }
}
