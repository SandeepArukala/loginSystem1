
  package com.student.Service;
  
  import java.util.Arrays;
import java.util.Collection;
import
  java.util.stream.Collectors;

 

import org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.security.core.GrantedAuthority;
import
  org.springframework.security.core.authority.SimpleGrantedAuthority;
import
 org.springframework.security.core.userdetails.UserDetails;
import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import
  org.springframework.stereotype.Service;

import com.student.Entity.Role;
import com.student.Entity.User;
import com.student.Repositiry.UserRepository;
import com.student.web.dto.UserRegistrationDTO;
  
  @Service 
  public class UserServiceImpl implements UserService {
  
  
  
 private UserRepository userrepo;
  
  @Autowired 
  private final BCryptPasswordEncoder passwordEncoder;
  
  public UserServiceImpl(UserRepository userrepo, BCryptPasswordEncoder passwordEncoder) { 
	  this.userrepo = userrepo; 
	  this.passwordEncoder = passwordEncoder; 
	  
  }
  
	  public User save(UserRegistrationDTO registrationDto) { 
		//  String ROLE_USER = "ROLE_USER"; 
		  User user = new User(registrationDto.getFirstname(),
			  registrationDto.getLastname(), 
			  registrationDto.getEmail(),
			  
			  passwordEncoder.encode(registrationDto.getPassword()),
		      Arrays.asList(new Role("ROLE_USER"))  );
		  
				  return userrepo.save(user); }
				 
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		  
	  User user = userrepo.findByEmail(username);
  
	  if (user == null) { 
		  
		  throw new  UsernameNotFoundException("invallid Username or Password"); 
	  
	  } 
	  
	  return new org.springframework.security.core.userdetails.User(user.getEmail(),
	  user.getPassword(), mapRolesToAuthorities(user.getRoles())); 
	  }
	 
	  
	  
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) { 
			  
		    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		  
		  }
	
		  }
 
