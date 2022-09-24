package com.ideas2it.model;

import com.ideas2it.model.Profile;

/**
 * Contain the attributes of the User
 * Constructor is used to initialize the attributes 
 * and getter and setter method  is used to update and retrive the attributes
 * tostring method is used to return the values
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private int    age;
    private Profile profile;
    
    public User() {}

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    } 
    
    public void setGender(String gender) { 
        this.gender = gender;
    }
   
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Profile getProfile() {
        return profile;
    }
   
    public String getGender() {
        return gender;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
     
    public String getPhoneNumber() { 
        return phoneNumber;
    }
    
    public String toString() {
        return"\nName    : "+ name
                +"\nEmail : "+ email
                +"\nGender: "+ gender
                +"\nDOB   : "+ dateOfBirth
                +"\nAge   : "+ age
                +"\nPhNo  : "+ phoneNumber ;
     }
}