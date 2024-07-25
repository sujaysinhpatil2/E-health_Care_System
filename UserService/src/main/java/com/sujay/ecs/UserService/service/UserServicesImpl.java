package com.sujay.ecs.UserService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujay.ecs.UserService.entity.User;
import com.sujay.ecs.UserService.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public int addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

}
