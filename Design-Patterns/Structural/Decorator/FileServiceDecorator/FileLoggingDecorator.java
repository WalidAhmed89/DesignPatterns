package Structural.Decorator.FileServiceDecorator;

public class FileLoggingDecorator extends FileServiceDecorator{

    public String logging(String fileName){
        return "Reading file: "+fileName;
    }
    public String encryption(String fileName){
        return fileName+" [ENCRYPTED]";
    }

    @Override
    public String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        result.append(super.readFile(fileName)).append("\n");
        result.append(logging(fileName)).append("\n");
        return result.toString();
    }


}
