package com.juanpabloprado.departmentservice.department;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
        DepartmentResponse savedDepartment = departmentService.saveDepartment(departmentRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}")
                .buildAndExpand(savedDepartment.getDepartmentCode()).toUri();
        return ResponseEntity.created(location).body(savedDepartment);
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable String code) {
        DepartmentResponse departmentResponse = departmentService.getDepartmentByCode(code);
        return ResponseEntity.ok(departmentResponse);
    }
}