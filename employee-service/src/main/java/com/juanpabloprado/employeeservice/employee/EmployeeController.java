package com.juanpabloprado.employeeservice.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse savedEmployee = employeeService.saveEmployee(employeeRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).body(savedEmployee);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable long id) {
        EmployeeResponse employeeById = employeeService.getEmployeeById(id);
        if (employeeById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employeeById);
    }
}
