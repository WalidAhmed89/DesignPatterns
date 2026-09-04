package Creational_Patterns.Builder.SmartHouse;

import java.util.LinkedList;

public class House {
    LinkedList<String> houseComponents;

    public House() {
        houseComponents = new LinkedList<String>();
    }

    public void Add(String component) {
        houseComponents.add(component);
    }

    public String Show(){
        StringBuilder result = new StringBuilder();
        System.out.println("House Components: \n");
        for(String component : houseComponents){
            result.append(component);
        }
        return result.toString();
    }

}
