package com.cyy.jpa;

import com.cyy.jpa.entity.User;
import com.cyy.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/findById")
    public User findById(Integer id) {

        return userService.findById(id);

    }

    @RequestMapping( value = "/find")
    public List<User> find(String name, Integer age) {

        return userService.find(name,age);

    }
}
