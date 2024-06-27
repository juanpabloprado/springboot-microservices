package com.juanpabloprado.employeeservice.employee;

import com.juanpabloprado.employeeservice.department.DepartmentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private EmployeeResponse employee;
    private DepartmentResponse department;
}