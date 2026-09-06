package Structural.Adapter.Employees;

public class SalaryAdapter{
    private Employee employeeAdapter;
    private SalaryCalculator calculator;

    public double calculateSalaryOperation(MachineOperation operation){
        employeeAdapter = new Employee();
        calculator = new SalaryCalculator();
        employeeAdapter.employeeBasicSalary = operation.operationBasicSalary;
        return calculator.calculateSalary(employeeAdapter);
    }
}
