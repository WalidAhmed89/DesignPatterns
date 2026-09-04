package Creational.Prototype;

public class TempEmployee extends EmployeePrototype{

    @Override
    public EmployeePrototype ShallowCopy() throws CloneNotSupportedException {
        return (TempEmployee)super.clone();
    }

    @Override
    public EmployeePrototype DeepCopy() throws CloneNotSupportedException {
        TempEmployee copy = new TempEmployee();

        copy = (TempEmployee)super.clone();
        copy.EmpAddress = new Address(
                this.EmpAddress.Building,
                this.EmpAddress.StreetName,
                this.EmpAddress.City
        );
        return copy;
    }
}
