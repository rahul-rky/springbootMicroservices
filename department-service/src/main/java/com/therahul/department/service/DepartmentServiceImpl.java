package com.therahul.department.service;

import com.therahul.department.entity.Department;
import com.therahul.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        log.info("Inside findAll method of DepartmentSerive");
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        log.info("Inside getDepartment method of DepartmentService");
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department addDepartment(Department department) {
        log.info("Inside addDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }
}
