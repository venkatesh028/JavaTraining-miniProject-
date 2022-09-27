package com.ideas2it.dao.daoImpl;

import java.util.Map;
import java.util.HashMap;

import com.ideas2it.model.User;
import com.ideas2it.model.Profile;
import com.ideas2it.dao.UserDao;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 22-SEP-2022
 * @author  Venkatesh TM
 */
public class UserDaoImpl implements UserDao {
    private Map<String, User> users;
    private Map<String, String> loginCredentials;
    private User user;
    private static  UserDaoImpl userDaoImpl;

    private UserDaoImpl() {
        this.users = new HashMap<>();
        this.loginCredentials = new HashMap<>();
    }

   /**
    * Creating the obj for the UserDao only for one time 
    *
    * @return userDao userDao is the object of the userDao
    */
    public static synchronized UserDaoImpl getInsatance() {
        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }	
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean createAccount(User user) {
        users.put(user.getUserId(), user);
        loginCredentials.put(user.getEmail(), user.getUserId());
        return true;        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteAccount(String userId) {
        users.remove(userId);
        return true;    
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, User> getUsers() {
        return users;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserById(String userId) {
        return users.get(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Profile getProfile(String userId) {
        return users.get(userId).getProfile();
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public Map<String, String> getLoginCredentials() {
        return loginCredentials;    
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public boolean updateUser(String userId, User user) {
        users.put(userId, user);
        return true;   
    }

    /**
     * {@inheritDoc}
     */
    @Override   
    public String getUserName(String userId) {
        user = users.get(userId);
        return user.getProfile().getUserName();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override   
    public boolean updateLoginCredentials (String oldEmail, String newEmail) {
        String userId;
        userId = loginCredentials.remove(oldEmail);
        loginCredentials.put(newEmail, userId);
        return true;        
    }
}