package com.sujay.ecs.UserService.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sujay.ecs.UserService.DTO.AdminResponce;
import com.sujay.ecs.UserService.entity.User;
import com.sujay.ecs.UserService.model.Admin;
import com.sujay.ecs.UserService.service.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserServices userServices;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String login() {
		return ("<h1>Welcome user</h1>");
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = userServices.findById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<Integer> addUser(@RequestBody User user) {
		int userId = userServices.addUser(user);
		return new ResponseEntity<>(userId,HttpStatus.OK);
	}

	@GetMapping("/getAllUsersByRole/{role}")
	public ResponseEntity<List<User>> getAllUsersByRole(@PathVariable String role) {
		List<User> user = userServices.findByRole(role);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@GetMapping("/getAdminListFromUser")
    @CircuitBreaker(name = "userService", fallbackMethod = "giveAllUsersWithAdminRole")
    public ResponseEntity<AdminResponce> getAdminListFromUser() {
        List<Admin> adminList = restTemplate.getForObject("http://ADMINSERVICE/admin/getAllAdmin", List.class);
        AdminResponce adminResponce = new AdminResponce(adminList);
        return new ResponseEntity<>(adminResponce, HttpStatus.OK);
    }

    public ResponseEntity<AdminResponce> giveAllUsersWithAdminRole(Throwable t) {
        logger.error("Error occurred while fetching admin list: {}", t.getMessage());
        List<Admin> adminList = new ArrayList<>();
        AdminResponce adminResponce = new AdminResponce(adminList);
        return new ResponseEntity<>(adminResponce, HttpStatus.OK);
    }

}
