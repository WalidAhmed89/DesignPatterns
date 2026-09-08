package Structural.Composite.FileSystem;

import java.util.List;

public class Folder implements IFileSystemComponent{
    private final String fileName;
    private List<IFileSystemComponent> folderStructure;

    public Folder(String fileName,List<IFileSystemComponent> folderStructure){
        this.fileName = fileName;
        this.folderStructure = folderStructure;
    }

    public void add(IFileSystemComponent file){
        folderStructure.add(file);
    }

    public void remove(IFileSystemComponent name){
        folderStructure.remove(name);
    }
    @Override
    public String showDetails() {
        StringBuilder result = new StringBuilder();
        result.append(fileName);
        for(IFileSystemComponent file : folderStructure){
            result.append(file.showDetails()).append("\n");
        }
        return result.toString();
    }
}
