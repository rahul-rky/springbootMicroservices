package com.therahul.user.service;

import com.therahul.user.VO.Department;
import com.therahul.user.VO.ResponseTemplateVO;
import com.therahul.user.entity.User;
import com.therahul.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }


    @Override
    public ResponseTemplateVO getUserWithDepartment(long userId) {
        log.info("inside getUserWithDepartmet method of userService");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=repository.findById(userId).get();
        System.out.println("user = " + user);
        Department department=
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }


}
