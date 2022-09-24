package com.ideas2it.dao.daoImpl;

import java.util.List;
import java.util.ArrayList;

import com.ideas2it.model.Post;
import com.ideas2it.dao.PostDao;

/**
 * Perform add, update and get function for the post
 * 
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class PostDaoImpl implements PostDao {
    private List<Post> userPost;
    private static PostDaoImpl postDaoImpl;

    private PostDaoImpl() {
        this.userPost = new ArrayList<>();
    }
    
    /**
     * Creating the obj for the PostDao only for one time 
     *
     * @return postDao postDao is the object of the PostDao
     */
    public static synchronized PostDaoImpl getInsatance() {
        if (postDaoImpl == null) {
            postDaoImpl = new PostDaoImpl();
        }
        return postDaoImpl;
    }
    
    /**
     * Add the post 
     * 
     * @param  postedBy name of the user who posted the post
     * @parma  quotes   post of the user 
     * @return boolean  true after adding the post
     */   
    public boolean addPost(Post post) {
        userPost.add(post);
        return true;   
    }
    
    /**
     * Get all the post in the list
     * 
     * @return userPost list of post uploaded
     */
    public List<Post> getUserPost() {
        return userPost;
    }
     
    public boolean updatePost(List<Post> userPost) {
        this.userPost = userPost;
        return true;
    }   
    
}