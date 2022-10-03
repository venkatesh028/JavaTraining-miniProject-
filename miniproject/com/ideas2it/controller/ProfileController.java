package com.ideas2it.controller;

import com.ideas2it.service.ProfileService;
import com.ideas2it.model.Profile;

/**
 * Perform the set, get and update operation for the profile
 *
 * @version 1.0 23-SEP-2022
 * @author  Venkatesh TM
 */
public class ProfileController {
    
    ProfileService profileService;

    public ProfileController() {
        this.profileService = new ProfileService();
    }
    
    /**
     * Shows the profile of the user
     * 
     * @param  userId  userId of the user
     * @return Profile profile of the user
     */
    public Profile getProfile(String userId) {
        return profileService.getProfile(userId);
    } 

    /**
     * Update the username of the user
     *
     * @param  userId      userId of the user
     * @param  newUserName new username of the user
     * @return boolean     true after the userName update
     */
    public boolean updateUserName(String userId, String newUserName) {
        return profileService.updateUserName(userId, newUserName);
    }

    /**
     * Update bio of the user  
     * 
     * @param  userId  userId of the user
     * @param  bio     bio of the user 
     * @return boolean true after update
     */
    public boolean updateBio(String userId, String bio) {
        return profileService.updateBio(userId, bio);
    }

    /**
     * Gets the userName of the user
     *
     * @param  userId   userId of the user
     * @return userName userName of the user
     */
    public String getUserName(String userId) {
        return profileService.getUserName(userId);
    }
    
    /**
     * Gets the userprofile based on the username
     *
     * @param  userName     username searched by the user
     * @return usersProfile userprofile based on the userName
     */
    public Profile getUserProfile(String userName) {
        return profileService.getUserProfile(userName);
    }
       
} 
