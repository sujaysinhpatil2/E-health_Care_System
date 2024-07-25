package com.sujay.ecs.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujay.ecs.UserService.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findById(int id);
    public List<User> findByRole(String role);

}
