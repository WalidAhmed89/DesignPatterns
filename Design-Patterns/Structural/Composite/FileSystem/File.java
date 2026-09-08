package Structural.Composite.FileSystem;

public class File implements IFileSystemComponent{
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String showDetails() {
        return name;
    }
}
