package com.student.Entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name= "USER", uniqueConstraints= @UniqueConstraint(columnNames= "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="first_name")
	private String firstname;
	
	@Column(name ="last_name")
    private String lastname;
	
    private String email;
    
    private String password;
    
    
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    
    @JoinTable(
    		name="USERS_ROLES",
    		joinColumns = @JoinColumn(
    				name="USER_ID",referencedColumnName="ID"),
    		inverseJoinColumns=@JoinColumn(
    				name="ROLE_ID" , referencedColumnName="ID")
              )
    
    private Collection<Role> roles;
    
	public User() {}
	
	public User( String firstname, String lastname, String e_mail, String password, Collection<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = e_mail;
		this.password = password;
		this.roles = roles;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e_mail) {
		this.email = e_mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	
    
	
	

}
