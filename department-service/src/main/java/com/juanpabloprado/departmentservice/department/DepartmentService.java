package com.juanpabloprado.departmentservice.department;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentResponse saveDepartment(DepartmentRequest departmentRequest) {
        Department department = DepartmentMapper.mapToDepartment(departmentRequest);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentResponse(savedDepartment);
    }

    public DepartmentResponse getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDepartmentResponse(department);
    }
}
