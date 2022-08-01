/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsdeveloper.mobileappws.exceptions;

/**
 *
 * @author Float PC 1
 */
public class UserServiceException extends RuntimeException{
    
    private static final long serialVersionUID = 1348771109171435607L;
    
    public UserServiceException(String message)
    {
        super(message);
    }
    
}
