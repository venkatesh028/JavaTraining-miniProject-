package com.ideas2it.controller;

import java.util.List;

import com.ideas2it.model.Post;
import com.ideas2it.service.PostService;

public class PostController {
    private PostService postService;
     
    public PostController() { 
        this.postService = new PostService();
    }
    
    /**
     * Check the post is empty
     * 
     * @return boolean true or false based on the result
     */
    public boolean isPostEmpty() {
        return postService.isPostEmpty();
    }

    /**
     * Add the post 
     * 
     * @param  postedBy name of the user who posted the post
     * @parma  quotes   post of the user 
     * @return boolean  true after adding the post
     */
    public boolean addPost(String userId, String quotes) {
        return postService.addPost(userId, quotes);
    } 

    /**
     * Get the post uploaded by the user
     *
     * @return post list of post
     */
    public List<Post> showPost() {
        return postService.getUserPost();
    }   
    
    public boolean addLike(String likedUserName, String postId) {
        return postService.addLike(likedUserName, postId);
    }     
    
}
 