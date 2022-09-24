package com.ideas2it.dao;

import java.util.Map;

import com.ideas2it.model.User;
import com.ideas2it.model.Profile;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 22-SEP-2022
 * @author  Venkatesh TM
 */
public interface UserDao {

    /**
     * Create account for the user and add with id as key in users
     *  
     * @param  user     details of the user
     * @return boolean  true after adding the user in map
     */
    public boolean createAccount(User user);

    /** 
     * Delete the account
     * 
     * @param  userId  userId of the user
     * @return boolean true after deleting the account
     */
    public boolean deleteAccount(String userId);

    /** 
     * Get the all the users
     * 
     * @return users all the users
     */
    public Map<String, User> getUsers();

    /**
     * Get the particular user based on the userId
     * 
     * @param  userId userId of the user
     * @return user   particular userdetails 
     */ 
    public User getUserById(String userId);
    
    /**
     * Update the information of the user
     *
     * @paran  userId  userid of the user
     * @param  user    updated information of the user
     * @return boolean true after updating the user
     */
    public boolean updateUser(String userId, User user);

    /**
     * Get the profile of the particular user
     * 
     * @param  userId  userId of the user
     * @return profile profile of the particular user
     */    
    public Profile getProfile(String userId);
    
    /** 
     * Get the loginCredentials of the user
     *
     * @return loginCredentials logincredentials of the user
     */
    public Map<String, String> getLoginCredentials();
    
    /**
     * Get the username by the userId
     * 
     * @param  userId   user id of the user
     * @return username username of the user
     */  
    public String getUserName(String userId);
}