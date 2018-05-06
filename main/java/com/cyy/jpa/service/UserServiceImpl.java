package com.cyy.jpa.service;

import com.cyy.jpa.dao.UserRepository;
import com.cyy.jpa.entity.User;
import com.cyy.jpa.util.SpecificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }


    @Override
    public List<User> find(String name, Integer age) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);
       return userRepository.findAll(SpecificationUtil.getEqualSpec(map));
    }
}
