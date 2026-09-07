package Structural.Composite.JetpackCompose;

public class ImageView implements IComponent{
    private final String name;

    public ImageView(String name) {
        this.name = name;
    }

    @Override
    public String Name() {
        return name;
    }
}
