package Behavioral.Interpreter.Permission;

public class Program {
    public static void main(String[] args) {
        PermissionExpression firstPermission = new PermissionExpression("ADMIN");
        PermissionExpression secondPermission = new PermissionExpression("USER");
        PermissionExpression thirdPermission = new PermissionExpression("MANAGER");

        Expression expression = new AndExpression(firstPermission,new ORExpression(secondPermission,thirdPermission));

        System.out.println(expression.interpreter());

    }
}
