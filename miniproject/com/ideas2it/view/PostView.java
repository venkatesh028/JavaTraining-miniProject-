package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.PostController;
import com.ideas2it.controller.ProfileController; 
import com.ideas2it.constant.Constants;

/**
 * Shows the news feed page to user and based on is action shows further pages
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */ 
public class PostView {
    private PostController postController;
    private Scanner scanner;
    private ProfileController profileController;

    /**
     * Creates a new object for the PostView and initialize the feilds
     * of that class
     */ 
    public PostView() {
        this.postController = new PostController();
        this.profileController = new ProfileController();
        this.scanner = new Scanner(System.in);
    }
    
    /** 
     * Add the post by getting the quotes form the user
     * 
     * @param userName userName of the person who is uploading the post
     */ 
    public void addPost(String userId) {
        String quotes;
        String userName;
        System.out.print("Enter your quotes : ");
        quotes = scanner.nextLine();
        userName = profileController.getUserName(userId);
        if (postController.addPost(userName, quotes)) {
            System.out.println("Post added Successfully");
        }        
    }
    
    /** 
     * Add like to the post by getting the details about that post
     * 
     * @param likedUserName userName of the person who liked the post
     */
    public void addLike(String userId) {
        String likedUserName = profileController.getUserName(userId);
        System.out.println("Enter the post Id : ");
        String postId = scanner.nextLine();        
        postController.addLike(likedUserName, postId);                   
    }
    
    /**
     * Add comment to the post be getting the details about that post
     */
    public void addComment() {
        scanner.nextLine();
        System.out.print("Enter the UserName of the post : ");
        String userName = scanner.nextLine();
        System.out.print("Enter the post number : ");
        int postNumber = scanner.nextInt();   
        scanner.nextLine();
        System.out.print("Enter your comment : ");
        String comment = scanner.nextLine();

       /* if (postController.addComment(userName, comment, postNumber)) {
            System.out.println("Comment added successfully ");
        } */      
    }
    
    /**
     * Shows the post to the user and also provide the option to
     * Add post, like and comment 
     *
     * @param userId userId of the user who is in this page
     */
    public void displayPost(String userId) {      
        String userName = profileController.getUserName(userId);
        StringBuilder statement = new StringBuilder();
        int action;
        boolean postFeedRunning = true;
        statement.append("\nEnter ").append(Constants.ADDPOST)
                 .append(" --> To add post ").append("\nEnter ")
                 .append(Constants.LIKE).append(" --> To add like ")
                 .append("\nEnter ").append(Constants.COMMENT)
                 .append(" --> To add comment ")
                 .append("\nEnter ").append(Constants.EXIT_POSTPAGE)
                 .append(" --> To exit post feed : ");
    
        while (postFeedRunning) {        
            if (postController.isPostEmpty()) {
                System.out.println("Post is not available");    
            } else {
                System.out.println(postController.showPost());
                    
            } 
            
            System.out.println(statement);
            action = scanner.nextInt();
            scanner.skip("\r\n");

            switch (action) {
            case Constants.ADDPOST:
                addPost(userId);
                break;

            case Constants.LIKE:
                addLike(userId);
                break;

            case Constants.COMMENT:
                //addComment();
                break;

            case Constants.EXIT_POSTPAGE:
                postFeedRunning = false;
                break;

            default:
                System.out.println("You entered wrong option");

            }    
        }
    }
}