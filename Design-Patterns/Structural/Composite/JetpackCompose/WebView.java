package Structural.Composite.JetpackCompose;

public class WebView implements IComponent{
    private final String name;

    public WebView(String name) {
        this.name = name;
    }

    @Override
    public String Name() {
        return name;
    }
}
