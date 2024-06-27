package com.juanpabloprado.employeeservice.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeResponse(savedEmployee);
    }

    public EmployeeResponse getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.map(EmployeeMapper::mapToEmployeeResponse).orElse(null);
    }
}
