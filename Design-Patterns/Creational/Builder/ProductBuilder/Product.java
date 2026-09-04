package Creational.Builder.ProductBuilder;

import java.util.LinkedList;

public class Product {
    LinkedList<String> parts;
    public Product(){
        parts = new LinkedList<String>();
    }

    public void Add(String part){
        parts.add(part);
    }

    public String Show(){
        StringBuilder result = new StringBuilder();
        result.append("Product Components are: \n");
        for(String part : parts){
            result.append(part);
        }
        return result.toString();
    }
}
