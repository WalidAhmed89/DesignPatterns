package Structural.Adapter.Employees;

public class SalaryCalculator {
    public double calculateSalary(Employee employee){
        return employee.employeeBasicSalary * 12.2;
    }
}
