/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsdeveloper.mobileappws.ui.model.response;

/**
 *
 * @author Float PC 1
 */
public enum ErrorMessages {
    
    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Reord already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id was not found"),
    AUTHENTICATION_FALED("Authentication Failed"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");
    
    private String errorMessage;
    
    ErrorMessages(String errorMessage){
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage(){
        return errorMessage;    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
