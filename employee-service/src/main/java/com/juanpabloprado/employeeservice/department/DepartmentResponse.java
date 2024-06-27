package com.juanpabloprado.employeeservice.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
