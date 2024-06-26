package com.juanpabloprado.employeeservice.department;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("department-service")
public interface DepartmentClient {
    @GetMapping("api/departments/{code}")
    DepartmentResponse getDepartment(@PathVariable String code);
}