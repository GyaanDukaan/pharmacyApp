package com.pharma.pharma;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value ="/api")
public class LoginController {

	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String Authorize(@RequestParam String phoneNumber,@RequestParam String passwd,@RequestParam String cityName)
	{
		
		return loginService.Authorize(phoneNumber, passwd, cityName);
   }
	
	@PostMapping(value = "/SignUp")
	public String createUser(@RequestParam String phoneNumber,@RequestParam String passwd)
	{
	  return loginService.createUser(phoneNumber, passwd);	
    }
	
}
