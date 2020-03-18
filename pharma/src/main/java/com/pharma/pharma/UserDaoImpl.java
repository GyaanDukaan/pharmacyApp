package com.pharma.pharma;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserRepositry repo;
	
	
	public Optional<User> getUser(String phoneNumber) {
		return repo.findById(phoneNumber);
   }
	
	public void createUser(User u)
	{
		repo.saveAndFlush(u);
	}
	
	
	
    
}	
	

