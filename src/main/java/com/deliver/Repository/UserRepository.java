package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deliver.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query(value="select id from user where email=?1",nativeQuery=true)
	Integer findUserIdByEmail(String email);

	@Query(value="select id from user where email=?1 and password=?2 and role=?3",nativeQuery=true)
	Integer loggedIn( String email,String pass,String role);
	
}
