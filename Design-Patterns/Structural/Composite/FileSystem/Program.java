package Structural.Composite.FileSystem;

import java.util.List;

public class Program {
    static void main(String[] args) {
        File file1 = new File("resume.pdf");
        File file2 = new File("notes.txt");
        File file3 = new File(" project1.java");
        File file4 = new File("project2.java");
        Folder folder1 = new Folder("Projects", List.of(file3,file4));
        Folder folder2 = new Folder("Root", List.of(file1,file2,folder1));

        System.out.println(folder2.showDetails());

    }
}
