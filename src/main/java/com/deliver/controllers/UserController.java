package com.deliver.controllers;

import com.deliver.Service.UserService;
import com.deliver.entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/user/{id}")
//	@CrossOrigin("*")
	Optional<User> getUser(@PathVariable int id) {
		return this.userService.getUser(id);
	}

	@GetMapping("/users")
	List<User> GetAllUser() {
		return this.userService.getAllUser();
	}

	// @ResponseBody
	@PostMapping("/user")
	User create(@RequestBody User user) {
		System.out.println("inside controler create function user recieeved " + user);

		Integer idFetched = userService.getUserIdByEmail(user.getEmail());
		System.out.println("id fetched is ->" + idFetched);

		if (idFetched == 0)
			return this.userService.createUser(user);
		else
			return null;
	}

	@PostMapping("/login")
	int login(@RequestBody User user) {
		Integer idFetched = userService.login(user);
		if (idFetched == 0)
			return 0;
		else
			return idFetched;
	}

}
