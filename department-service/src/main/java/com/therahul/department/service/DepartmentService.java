package com.therahul.department.service;

import com.therahul.department.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> getAllDepartment();
    Department getDepartmentById(long id);
    Department addDepartment(Department department);
}
