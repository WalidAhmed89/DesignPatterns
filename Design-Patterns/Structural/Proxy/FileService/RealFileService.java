package Structural.Proxy.FileService;

public class RealFileService implements IFileService{
    @Override
    public String readFile(String fileName) {
        return "File Name: "+fileName;
    }

    @Override
    public String deleteFile(String fileName) {
        return "File Name: "+fileName;
    }
}
