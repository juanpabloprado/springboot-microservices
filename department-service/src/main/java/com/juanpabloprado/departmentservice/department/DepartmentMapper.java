package com.juanpabloprado.departmentservice.department;

public class DepartmentMapper {

    public static DepartmentResponse mapToDepartmentResponse(Department department){
        return new DepartmentResponse(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    public static Department mapToDepartment(DepartmentRequest departmentRequest){
        return new Department(
                departmentRequest.getId(),
                departmentRequest.getDepartmentName(),
                departmentRequest.getDepartmentDescription(),
                departmentRequest.getDepartmentCode()
        );
    }
}