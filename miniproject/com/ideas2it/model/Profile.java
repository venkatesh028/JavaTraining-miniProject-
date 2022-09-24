package com.ideas2it.model;

import java.util.List;

import com.ideas2it.model.Post;

/**
 * Contain the attributes of the Profile
 * Constructor is used to initialize the attributes 
 * and getter and setter method  is used to update and retrive the attributes
 * tostring method is used to return the values
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class Profile {
    private String userName;
    private String bio;
    private int friendsCount;
    private List<Post> post; 
    
    public Profile() {}

    public Profile(String userName) {
        this.userName = userName;
        this.friendsCount = 0;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public void setFriendsCount() {
        this.friendsCount++;
    }
    
    public void setPost(List<Post> post) {
        this.post = post;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getBio() {
        return bio;
    }
    
    public int getFriendsCount() {
        return friendsCount;
    }
    
    public String toString() {
        return "\nuserName  : "+ userName
                +"\nBio     : "+ bio
                +"\nFriends : "+ friendsCount;
    }
}  