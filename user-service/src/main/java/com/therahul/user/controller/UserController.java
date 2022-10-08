package com.therahul.user.controller;

import com.therahul.user.VO.ResponseTemplateVO;
import com.therahul.user.entity.User;
import com.therahul.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll(){
        return service.getAllUser();
    }

//    @GetMapping("/{id}")
//    public User findById(@PathVariable("id") long id){
//        return service.getUserById(id);
//    }

    @PostMapping
    public User save(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/{userId}")
    @Retry(name = "user-service",fallbackMethod = "userServiceFallback")
//    @CircuitBreaker(name = "user-service", fallbackMethod = "userServiceFallback")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId){
        System.out.println("Retrying...");
        return service.getUserWithDepartment(userId);
    }

    public ResponseTemplateVO userServiceFallback(Exception ex){
        return new ResponseTemplateVO();
    }

}
