package Creational_Patterns.Builder.Computer;

import java.util.LinkedList;

public class Computer {
    LinkedList<String> ComputerParts;

    public Computer() {
        ComputerParts = new LinkedList<String>();
    }

    public void Add(String part){
        ComputerParts.add(part);
    }

    public String Show(){
        StringBuilder results = new StringBuilder();
        results.append("ComputerParts Components: \n");
        for(String part : ComputerParts){
            results.append(part);
        }

        return results.toString();
    }

}
