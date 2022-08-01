/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsdeveloper.mobileappws.security;

import com.appsdeveloper.mobileappws.SpringApplicationContext;
import com.appsdeveloper.mobileappws.service.UserService;
import com.appsdeveloper.mobileappws.shared.dto.UserDto;
import org.springframework.security.core.Authentication;
import com.appsdeveloper.mobileappws.ui.model.request.UserLoginRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author farie
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public final AuthenticationManager authenticationManager;
    
    public AuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, 
            HttpServletResponse res){
        try{
            UserLoginRequestModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLoginRequestModel.class);
            
            return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            creds.getEmail(), 
            creds.getPassword(),
            new ArrayList<>()
            ));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req, 
            HttpServletResponse res, 
            FilterChain chain, 
            Authentication auth) throws IOException, ServletException{
        String username = ((User) auth.getPrincipal()).getUsername();
        
        
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
                .compact();
        
        UserService userService = (UserService)SpringApplicationContext.getBean("userServiceimpl");
        UserDto userDto = userService.getUser(username);
        
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.addHeader("UserID", userDto.getUserId());
     
    }
    
}
