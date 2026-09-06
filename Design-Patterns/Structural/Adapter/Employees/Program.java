package Structural.Adapter.Employees;

public class Program {
    static void main(String[] args) {
        Employee employee = new Employee("Walid Ahmed",15000);
        MachineOperation operation = new MachineOperation("Frosted",10000,"3020854753");
        SalaryAdapter calculatorOperation = new SalaryAdapter();
        SalaryCalculator calculatorEmployee = new SalaryCalculator();
        double employeeSalary = calculatorEmployee.calculateSalary(employee);
        double operationSalary = calculatorOperation.calculateSalaryOperation(operation);

        System.out.println(Double.toString(employeeSalary));
        System.out.println(Double.toString(operationSalary));
    }
}
