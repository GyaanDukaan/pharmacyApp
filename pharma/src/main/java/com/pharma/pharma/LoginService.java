package com.pharma.pharma;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(value ="/api")
public class LoginService {
	@Autowired 
	UserDaoImpl userDaoImpl;
	
	public String Authorize(String phoneNumber,String passwd,String cityName)
	{
		Optional<User> user = userDaoImpl.getUser(phoneNumber);
		if(user.isPresent() == true)
		{		
	    if(user.get().passwd.equals(passwd))
	    {
	    	return "Successfully Login";
	    }
		}
		return "User does not exist";
   }
	
	public String createUser(String phoneNumber,String passwd)
	{
		Optional<User> user = userDaoImpl.getUser(phoneNumber);
		
		User newUser = new User();
		if(user.isPresent() == true)
		{		
	    if(user.get().getPasswd().equals(passwd))
	    {
	    	return "User already exist";
	    }
		}
		newUser.setPhoneNumber(phoneNumber);
		newUser.setPasswd(passwd);
		userDaoImpl.createUser(newUser);
		return "Successfully Updated";
   }

	
}
