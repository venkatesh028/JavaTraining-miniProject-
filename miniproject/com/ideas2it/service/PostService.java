package com.ideas2it.service;

import java.util.UUID;
import java.util.List;

import com.ideas2it.model.Post;
import com.ideas2it.dao.PostDao;
import com.ideas2it.dao.daoImpl.PostDaoImpl;

/**
 * Perform the add post, like and comment for the post 
 * 
 * @version 1.0 23-SEP-2022
 * @author Venkatesh TM
 */
public class PostService {
    private Post post; 
    private PostDao postDao;
    private String postId;
    private List<Post> userPost;
    
    public PostService() {
        this.postDao = PostDaoImpl.getInsatance();
    }
    
    /**
     * Check the post is empty
     * 
     * @return boolean true or false based on the result
     */
    public boolean isPostEmpty() {
        userPost = postDao.getUserPost();
        return userPost.isEmpty();
    }
    
    /**
     * Add the post 
     * 
     * @param  postedBy name of the user who posted the post
     * @parma  quotes   post of the user 
     * @return boolean  true after adding the post
     */
    public boolean addPost(String postedBy, String quotes) {
        postId = UUID.randomUUID().toString();
        post = new Post(postId, postedBy, quotes);
        return postDao.addPost(post);  
    }
    
    public boolean addLike(String likedUserName, String postId) {
        userPost = postDao.getUserPost();
        for (Post post : userPost) {
            if (post.getPostId().equals(postId)) {
                if (post.getLikedUsers().contains(likedUserName)) {
                    post.setUnlike();
                    post.getLikedUsers().remove(likedUserName);
                } else {
                    post.setLike();
                    post.getLikedUsers().add(likedUserName);
                }
            }              
        }
        
        return postDao.updatePost(userPost);
    }
    
    /**
     * Get the post uploaded by the user
     *
     * @return post list of post
     */
    public List<Post> getUserPost() {
        return postDao.getUserPost();
    }

}