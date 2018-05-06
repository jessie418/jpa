package com.cyy.jpa.service;

import com.cyy.jpa.entity.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> find(String name,Integer age);
}
