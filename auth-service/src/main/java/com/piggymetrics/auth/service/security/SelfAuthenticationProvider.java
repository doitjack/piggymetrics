package com.piggymetrics.auth.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SelfAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    MongoUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal(); // 这个获取表单输入中返回的用户名;
        String rawPassword = (String) authentication.getCredentials(); // 这个是表单中输入的密码；
       

        UserDetails user = userDetailsService.loadUserByUsername(username);
          
          
        if (!new BCryptPasswordEncoder().matches(rawPassword, user.getPassword()) ) {
        	
            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
        }

        return new UsernamePasswordAuthenticationToken(username, rawPassword, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
