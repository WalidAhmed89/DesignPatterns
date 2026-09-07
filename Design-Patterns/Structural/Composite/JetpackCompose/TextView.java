package Structural.Composite.JetpackCompose;

public class TextView implements IComponent{
    private final String name;

    public TextView(String name) {
        this.name = name;
    }

    @Override
    public String Name() {
        return name;
    }
}
