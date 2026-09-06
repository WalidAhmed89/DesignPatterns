package Structural.Adapter.Employees;

public class MachineOperation {
    String operationName;
    double operationBasicSalary;
    String operationCode;

    public MachineOperation(String operationName,double operationBasicSalary,String operationCode){
        this.operationName = operationName;
        this.operationBasicSalary = operationBasicSalary;
        this.operationCode = operationCode;
    }
}
