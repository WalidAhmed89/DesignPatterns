package Structural.Composite.JetpackCompose;

import java.util.List;

public class Container implements IComponent{
    private final String name;
    private final List<IComponent> children;

    public Container(String name,List<IComponent>children){
        this.name = name;
        this.children = children;
    }


    @Override
    public String Name() {
        return name ;
    }

    public void printChildren(){
        children.forEach(child -> System.out.println("Container has : "+child.Name()));
    }
}
