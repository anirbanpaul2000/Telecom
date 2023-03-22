package com.stl.telecom.web.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.telecom.web.application.model.TeleUser;
import com.stl.telecom.web.application.service.UserLoginService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class TeleUserController {

	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/register")
	public String createUser(@RequestBody TeleUser userLogin) {
		userLoginService.register(userLogin);
		return "Registered Successfully";
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody TeleUser userLogin) throws Exception {
		String Add=userLoginService.login(userLogin);
		return  ResponseEntity.ok(Add);

	}
	
}

