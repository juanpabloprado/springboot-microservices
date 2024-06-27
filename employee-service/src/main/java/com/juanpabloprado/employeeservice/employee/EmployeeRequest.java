package com.juanpabloprado.employeeservice.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
}
