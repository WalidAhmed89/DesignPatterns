package Structural.Decorator.FileServiceDecorator;

public class FileDeletionDialogDecorator extends FileServiceDecorator{
    public String DeletionDialog(String fileName){
        return "are you sure u want to delete this file: "+ fileName;
    }

    @Override
    public String deleteFile(String fileName) {
        StringBuilder result = new StringBuilder();
        result.append(DeletionDialog(fileName)).append("\n");
        result.append(super.deleteFile(fileName)).append("\n");
        return result.toString();
    }
}
