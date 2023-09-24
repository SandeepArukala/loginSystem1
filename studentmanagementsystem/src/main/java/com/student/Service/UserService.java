package com.student.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.student.Entity.User;
import com.student.web.dto.UserRegistrationDTO;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDTO registrationdto);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
