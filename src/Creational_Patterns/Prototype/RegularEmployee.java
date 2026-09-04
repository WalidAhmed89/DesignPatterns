package Creational_Patterns.Prototype;

public class RegularEmployee extends EmployeePrototype{

    @Override
    public EmployeePrototype ShallowCopy() throws CloneNotSupportedException {
        return (RegularEmployee)super.clone();
    }

    @Override
    public EmployeePrototype DeepCopy() throws CloneNotSupportedException {
        RegularEmployee copy = new RegularEmployee();

        copy = (RegularEmployee)super.clone();
        copy.EmpAddress = new Address(
                this.EmpAddress.Building,
                this.EmpAddress.StreetName,
                this.EmpAddress.City
        );
        return copy;
    }
}
