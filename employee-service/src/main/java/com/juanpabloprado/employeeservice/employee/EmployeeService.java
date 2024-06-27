package com.juanpabloprado.employeeservice.employee;

import com.juanpabloprado.employeeservice.department.DepartmentClient;
import com.juanpabloprado.employeeservice.department.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeResponse(savedEmployee);
    }

    public ApiResponse getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        EmployeeResponse employeeResponse = optionalEmployee.map(EmployeeMapper::mapToEmployeeResponse).orElse(null);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            DepartmentResponse departmentResponse = departmentClient.getDepartment(employee.getDepartmentCode());

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setEmployee(employeeResponse);
            apiResponse.setDepartment(departmentResponse);

            return apiResponse;
        }
        return null;
    }

}
