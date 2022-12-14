package com.ideas2it.service;

import com.ideas2it.model.Profile;

/** 
 * Perform the Create, update, delete taks for the user profile
 * 
 * @version 1.0 22-SEP-2022
 * @author  Venkatesh TM
 */
public class ProfileService {
    private UserService userService;
    private Profile profile;

    public ProfileService() {
        this.userService = new UserService();
    }
    
    /**
     * get the profile of the user 
     *
     * @param  userId  userId of the user
     * @return profile profile details of the user
     */
    public Profile getProfile(String userId) {
        return userService.getProfile(userId);
    }
    
    /**
     * Update the username of the user
     *
     * @param  userId      userId of the user
     * @param  newUserName new username of the user
     * @return boolean     true after the userName update
     */
    public boolean updateUserName(String userId, String newUserName) {
        profile = userService.getProfile(userId);
        profile.setUserName(newUserName);
        return true;     
    }
    
    /**
     * Update bio of the user  
     * 
     * @param  userId  userId of the user
     * @param  bio     bio of the user 
     * @return boolean true after update
     */
    public boolean updateBio(String userId, String bio) {
        profile = userService.getProfile(userId);
        profile.setBio(bio);
        return true;    
    } 
    
    /**
     * Get the username of the user
     * 
     * @param  userId   userId of the user
     * @return userName username of the user 
     */
    public String getUserName(String userId) {
        return userService.getUserName(userId);
    }

    /**
     * Gets the userprofile based on the username
     *
     * @param  userName     username searched by the user
     * @return usersProfile userprofile based on the userName
     */ 
    public Profile getUserProfile(String userName) {      
        return userService.getUserProfile(userName);    
    }
    
    /**
     * Chagne the visibility of the user from the public or private 
     * Based on the user request
     *
     * @param  userId  userId of the particular user
     * @param  boolean true or false based on the user selection
     * @return boolean true after changing the visibility
     */
    public boolean changeVisibility(String userId, boolean isPrivate) {
        profile = userService.getProfile(userId);
        profile.setPrivate(isPrivate);
        return true;
    }
    
    /**
     * Add friend name to the particular user 
     * 
     * @param  userId     userId of the user to who the name going to get add
     * @parma  friendName requested user name 
     * @return boolean    true after adding the name
     */
    public boolean addFriend(String userId, String friendName) {
        profile = userService.getProfile(userId);
        profile.setFriend(friendName);
        return true;
    }    
}