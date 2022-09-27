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
    
    /**
     * Add like to the post based on id of the post
     * 
     * @param  likedUserName userName of the user who like 
     * @param  postId        Id of the post
     * @return boolean       true after adding the like 
     */ 
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
     * Add comment to the particular post based on the postId
     * 
     * @param  postId  id of the post 
     * @param  comment comment entered by the user
     * @return boolean true or false based on the result
     */
    public boolean addComment(String postId, String comment) {
        userPost = postDao.getUserPost();

        for (Post post : userPost) {

            if (post.getPostId().equals(postId)) {
                post.setComment(comment);
                break;
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
    
    /**
     * Gets the post based on there userName 
     * 
     * @param  userName       userName of the user
     * @return postByUserName post of the particular user based on username
     */
    public String getPostByUserName(String userName) {
        userPost = getUserPost();
        StringBuilder postByUserName = new StringBuilder();
 
        for (int index = 0; index < userPost.size(); index++) {
            post = userPost.get(0);
            if (post.getPostedBy().equals(userName)) {
                postByUserName.append(post);        
            }
        }
        return postByUserName.toString();
    }
    
    /**
     * Delete the particular post of the user
     * Based on the postId
     * 
     * @param  postId  Id of the post
     * @return result  true or false 
     */
    public boolean deletePost(String postId) { 
        userPost = getUserPost();
        boolean result = false;
        for (int index = 0; index < userPost.size(); index++) {
            post = userPost.get(0);
            if (post.getPostId().equals(postId)) {
                result = postDao.deletePost(index);
                break;
            }
        }
        return result;
    }
    

}