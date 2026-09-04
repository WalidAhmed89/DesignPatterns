package Creational.Prototype;

public class Program {
    static void main(String[] args) throws CloneNotSupportedException {
        EmployeePrototype tempEmp1 = new TempEmployee();
        tempEmp1.Name = "Walid";
        tempEmp1.id = 1;
        tempEmp1.EmpAddress = new Address("b1","street Name","city1");

        EmployeePrototype tempEmp2 = tempEmp1.ShallowCopy();
        System.out.println("============== Temp Emp 1 Original Values ==============");
        System.out.println(tempEmp1.toString());
        System.out.println("============== Temp Emp 2 copy Values ==============");
        System.out.println(tempEmp2.toString());

        tempEmp2.EmpAddress.City = "Cairo";
        System.out.println("============== Temp Emp 1 Original Values ==============");
        System.out.println(tempEmp1.toString());
        System.out.println("============== Temp Emp 2 copy Values ==============");
        System.out.println(tempEmp2.toString());
    }
}
