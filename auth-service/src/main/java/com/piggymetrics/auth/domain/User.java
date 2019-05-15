package com.piggymetrics.auth.domain;
import com.google.common.collect.ImmutableMap;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends abstractUser {

	

	@Id
	private String id;
	
	private List<String> roles;
	
	private String username;

	private String password;
	
	private String firstName;

    private String lastName;
    
   // @NotNull
    //@Indexed(unique = true)
    @Email
    private String email;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = 
//    @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    private List<Role> authorities;
    
    private LocalDateTime lastLogin;

    private LocalDateTime lastTokenInvalidation;
    
    private boolean enabled;
    
    @CreatedDate
    private LocalDateTime created;
    
	
	
	

	@Builder.Default
    private Map<String, String> keyValueMap = new HashMap<>();


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



//	@Override
//	public String getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public void setId(String id) {
//		// TODO Auto-generated method stub
//		
//	}



	






	

	@Override
	public void updateLastLogin() {
		  this.lastLogin = LocalDateTime.now(ZoneOffset.UTC);
		
	}







	 @Override
	    public void updateLastTokenInvalidation() {
	        this.lastTokenInvalidation = LocalDateTime.now(ZoneOffset.UTC);
	    }



	@Override
	public abstractUser addKeyValue(String key, String value) {
		 checkKeyValue(key, value);
	        keyValueMap.put(key.toLowerCase(), value);
	        return this;
	}



	@Override
	public void removeKeyValue(String key) {
		keyValueMap.remove(key.toLowerCase());
	}



	@Override
	public Map<String, String> getKeyValues() {
		 return ImmutableMap.copyOf(keyValueMap);
	}
}
