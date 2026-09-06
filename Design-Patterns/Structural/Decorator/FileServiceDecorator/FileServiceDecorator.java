package Structural.Decorator.FileServiceDecorator;

import Structural.Proxy.FileService.IFileService;

public abstract class FileServiceDecorator implements IFileService {
    IFileService fileService;

    public void setFileService(IFileService service){
        fileService = service;
    }

    @Override
    public String readFile(String fileName) {
        if(fileService != null){
            return fileService.readFile(fileName);
        }
        return "Read file service not initialized";
    }

    @Override
    public String deleteFile(String fileName) {
        if(fileService != null){
            return fileService.deleteFile(fileName);
        }
        return "delete file service not initialized";
    }
}
