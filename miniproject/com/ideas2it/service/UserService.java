package com.ideas2it.service;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.daoImpl.UserDaoImpl;
import com.ideas2it.model.User;

/**
 * Perform the Update, delete, create operation for the user
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class UserService {
    private Map<String, User> users;
    private Map<String, String> loginCredentials;
    private Set<String> existingData;
    private String userId;
    private UserDao userDao;
    private User user;
    
    public UserService() {
        this.userDao = UserDaoImpl.getInsatance();
        this.existingData = new HashSet<>();
    }

    /**
     * Check the email is exist already
     *
     * @param  email   email entered by the user
     * @return boolean true or false based on the result
     */ 
    public boolean isEmailExist(String email) {
        loginCredentials = userDao.getLoginCredentials();

        if (loginCredentials.containsKey(email)) {
            return true;
        } 
        return false;
    }
    
    /**
     * Create a account for the user and set the userId for the user
     *
     * @param  user  details of the user
     * @return boolean true after adding the account 
     */
    public boolean createAccount(User user) {
        userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userDao.createAccount(user);
    }
    
    /**
     * Delete the account of the user based on the user request 
     * 
     * @param  userId  userId of the user
     * @return boolean true after deleting the account
     */
    public boolean deleteAccount(String userId) {
        return userDao.deleteAccount(userId);
    }
   
    /**
     * Check the userName is exist already
     * 
     * @param  userName userName entered by the user
     * @return boolean  true or false based on the result
     */
    public boolean isUserNameExist(String userName) {
        existingData.clear();

        users = userDao.getUsers();
        for (User user : users.values()) {
            existingData.add(user.getProfile().getUserName());        
        }
        
        if (existingData.contains(userName)) {
            return true;
        }
        return false;
    }
    
    /**
     * Check the given login credentials is valid or not 
     * 
     * @param  email    email of the user
     * @return password password entered by the user
     */
    public boolean isValidCredentials(String email, String password) {
        users = userDao.getUsers();
        loginCredentials = userDao.getLoginCredentials();
        user = users.get(loginCredentials.get(email));

        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    
    /**
     * Get the userid of the user based on the email 
     *
     * @param  email  email entered by the user
     * @return userId userId of the user
     */
    public String getUserId(String email) {
        loginCredentials = userDao.getLoginCredentials();
        return loginCredentials.get(email);
    }
    
    /** 
     * Get the user Based on th id
     *
     * @param  userId userid of the user
     * @return user   user 
     */ 
    public User getUserById(String userId) {
        return userDao.getUserById(userId); 
    }

    /**
     * Shows the personal information of the user
     * 
     * @param  userId userId of the user
     * @return user   personal information of the user
     */    
    public User showPersonalInfo(String userId) {
        return userDao.getUserById(userId);
    }
    
    /**
     * Update the personal information of the user
     *
     * @param  userId   Id of the user
     * @param  user     updated personal information of the user
     * @return booelan  true after the updating
     */ 
    public boolean updateUser(String userId, User user) { 
        return userDao.updateUser(userId, user);
    }
    
    /**
     * Update the loginCredentials of the user
     * 
     * @param oldEmail old email in loginCredentials
     * @parma newEmail updated email of the user
     * @retun boolean  true after the update
     */
    public boolean updateLoginCredentials(String oldEmail, String newEmail) {
        return userDao.updateLoginCredentials(oldEmail, newEmail);        
    }
  
}