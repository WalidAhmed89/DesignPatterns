package Creational_Patterns.Prototype;

public abstract class EmployeePrototype implements Cloneable{
    public int id;
    public String Name;
    public Address EmpAddress;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getEmpAddress() {
        return EmpAddress;
    }

    public void setEmpAddress(Address empAddress) {
        EmpAddress = empAddress;
    }

    public abstract EmployeePrototype ShallowCopy() throws CloneNotSupportedException;
    public abstract EmployeePrototype DeepCopy() throws CloneNotSupportedException;

    @Override
    public String toString() {
        return "id: "+this.id+"\n Name: "+this.Name+"\n Address: "+this.EmpAddress.Building+", "+this.EmpAddress.StreetName+", "+this.EmpAddress.City;
    }
}
