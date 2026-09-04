package Structural.Proxy.FileService;

public class FileServiceProxy implements IFileService{
    private final IFileService _realFile;
    private String userType;

    public FileServiceProxy(String userType) {
        this.userType = userType;
        this._realFile = new RealFileService();
    }

    public String readFile(String fileName) {
        if (userType.equals("ADMIN") || userType.equals("USER")) {
            return _realFile.readFile(fileName);
        }

        return "Access Denied";
    }

    public String deleteFile(String fileName) {
        if (userType.equals("ADMIN")) {
            return _realFile.deleteFile(fileName);
        }
        return "Access Denied";
    }

}
