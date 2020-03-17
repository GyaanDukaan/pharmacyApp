package com.pharma.pharma;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RestController
public class LoginService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired 
	UserDaoImpl userDaoImpl;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String Authorize(@RequestParam String phoneNumber,@RequestParam String passwd,@RequestParam String cityName)
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
	
	
	
}
