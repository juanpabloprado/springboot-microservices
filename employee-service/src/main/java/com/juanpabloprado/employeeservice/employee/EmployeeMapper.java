package com.juanpabloprado.employeeservice.employee;

public class EmployeeMapper {

    public static EmployeeResponse mapToEmployeeResponse(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
    }

    public static Employee mapToEmployee(EmployeeRequest employeeRequest){
        return new Employee(
                employeeRequest.getId(),
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail(),
                employeeRequest.getDepartmentCode()
        );
    }
}