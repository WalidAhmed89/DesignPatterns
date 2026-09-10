package Behavioral.Interpreter.Permission;

import java.util.Set;

public class PermissionExpression implements Expression{
    private final Set<String> userPermissions = Set.of("ADMIN", "USER");
    private final String context;

    public PermissionExpression(String context) {
        this.context = context;
    }


    @Override
    public boolean interpreter() {
        return userPermissions.contains(context);
    }
}
