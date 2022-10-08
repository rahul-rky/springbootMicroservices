package com.therahul.user.service;

import com.therahul.user.VO.ResponseTemplateVO;
import com.therahul.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    ResponseTemplateVO getUserWithDepartment(long id);
    User saveUser(User user);

}
