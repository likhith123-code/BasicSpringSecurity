package com.example.Security.Configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Security.Model.User;
import com.example.Security.Repository.ApplicationRepository;

// This User Details gives authentication and authorization information
// If we don't override spring creates one user and password 

@Service
public class AuthenticationService implements UserDetailsService{
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = applicationRepository.findbyEmail(username);
		
		if(user==null)
			throw new UsernameNotFoundException("Invalid Credentials");
		
		return new UserDetails() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return new ArrayList<>();
			}
		};
		
	}

}
