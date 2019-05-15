package com.piggymetrics.auth.controller;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public Object test() {
		           
		return "void";  
	}

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		log.info("{}",principal);
		return principal;
	}
	   
	 //需要ROLE_ADMIN权限
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //
    @RequestMapping("/hasAuthority")
    public String hasAuthority (){
        return "hasAuthority  you!";
    }

	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		userService.create(user);
	}
}
