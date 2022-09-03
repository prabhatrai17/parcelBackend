package com.deliver.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.Repository.UserRepository;
import com.deliver.Service.UserService;
import com.deliver.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public Integer login(User user) {
		Integer result=userRepository.loggedIn(user.getEmail(), user.getPassword(),user.getRole());
		if(result==null) return 0;
		else return result;
	}
	

	public Integer getUserIdByEmail(String email) {
//		 int res;
//		try { 
//			res=userDao.findUserIdByEmail(email);
		// System.out.println("res found inside "+res);
//			res=1;
//		}
//		catch(Exception e){
//			res=0;
//		}
		Integer res = userRepository.findUserIdByEmail(email);
		if (res == null)
			return 0;
		else
			return res;
	}

	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}

	public User createUser(User user) {
		System.out.println("inside create user " + user);
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
