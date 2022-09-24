package com.ideas2it.controller;

import com.ideas2it.service.ProfileService;
import com.ideas2it.model.Profile;

/**
 * Perform the set, get and update operation for the profile
 *
 * @version 1.0 15-SEP-2022
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
    public Profile showProfile(String userId) {
        return profileService.showProfile(userId);
    } 

    /**
     * update the username of the user
     *
     * @param  userId      userId of the user
     * @param  newUserName new username of the user
     * @return boolean     true after the userName update
     */
    public boolean updateUserName(String userId, String newUserName) {
        return profileService.updateUserName(userId, newUserName);
    }

    /**
     * update bio of the user  
     * 
     * @param  userId  userId of the user
     * @param  bio     bio of the user 
     * @return boolean true after update
     */
    public boolean updateBio(String userId, String bio) {
        return profileService.updateBio(userId, bio);
    }

    /**
     * gets the userName of the user
     *
     * @param  userId   userId of the user
     * @return userName userName of the user
     */
    public String getUserName(String userId) {
        return profileService.getUserName(userId);
    }
       
} 
