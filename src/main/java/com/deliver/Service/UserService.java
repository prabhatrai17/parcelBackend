package com.deliver.Service;

import java.util.List;
import java.util.Optional;

import com.deliver.entities.User;

public interface UserService {
	
public Integer	getUserIdByEmail(String email);
public Optional<User> getUser(int id);
public User createUser(User user);
public List<User> getAllUser();

//public Integer loggedIn(String email,String pass);

public Integer login(User user);


}
