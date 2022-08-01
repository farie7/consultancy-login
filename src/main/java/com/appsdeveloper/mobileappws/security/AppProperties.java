/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsdeveloper.mobileappws.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author Float PC 1
 */

@Component
public class AppProperties {
    
    @Autowired
    private Environment env;
    
    public String getTokenSecret()
    {
       return env.getProperty("tokenSecret"); 
    }
    
}
