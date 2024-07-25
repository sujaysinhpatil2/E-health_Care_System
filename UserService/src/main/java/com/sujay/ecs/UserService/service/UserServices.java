package com.sujay.ecs.UserService.service;

import com.sujay.ecs.UserService.entity.User;
import java.util.List;

public interface UserServices {

    public User findById(int id);
    public int addUser(User user);
    public List<User> findByRole(String role);
    
}