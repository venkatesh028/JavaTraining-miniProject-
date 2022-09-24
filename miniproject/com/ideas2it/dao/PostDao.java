package com.ideas2it.dao;

import java.util.List;
import com.ideas2it.model.Post;

public interface PostDao {

    public boolean addPost(Post post);    

    public List<Post> getUserPost(); 

    public boolean updatePost(List<Post> userPost);
    
}