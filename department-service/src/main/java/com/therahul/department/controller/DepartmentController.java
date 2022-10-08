package com.therahul.department.controller;

import com.therahul.department.entity.Department;
import com.therahul.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/departments")
@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> findAll(){
        log.info("Inside findAll method of DepartmentController");
        return service.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") long id){
        log.info("Inside findById method of DepartmentController");
        return service.getDepartmentById(id);
    }

    @PostMapping
    public Department save(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        return service.addDepartment(department);
    }

}
