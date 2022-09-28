package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.ProfileController;
import com.ideas2it.controller.PostController;
import com.ideas2it.controller.UserController;
import com.ideas2it.constant.Constants;

/**
 * Shows the profile page to the user based on the user action
 * it takes toe further pages 
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class ProfileView {

    ProfileController profileController;
    PostController postController;
    UserController userController;
    Scanner scanner;
     
    public ProfileView() {
        this.profileController = new ProfileController();
        this.postController = new PostController();
        this.userController = new UserController();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Shows the update page 
     *
     * @param userId
     */
    private void updateProfile(String userId) {
        StringBuilder updateMessage = new StringBuilder();
        int selectedUpdate;
        boolean updatePage = true;
        updateMessage.append("\nEnter ").append(Constants.UPDATE_USERNAME)
               .append(" --> To update username ").append("\nEnter ")
               .append(Constants.UPDATE_BIO)
               .append(" --> To update Bio ").append("\nEnter ")
               .append(Constants.EXIT_UPDATEPAGE)
               .append(" --> To exit ");

        while (updatePage) {
            System.out.print(updateMessage);
            selectedUpdate = scanner.nextInt();         
      
            switch (selectedUpdate) {            
            case Constants.UPDATE_USERNAME:
                String newUserName;
                boolean userNameValid = false;

                while (!userNameValid) {
                    System.out.print("Enter the UserName : ");
                    newUserName = scanner.next();
                    
                    if (!userController.isUserNameExist(newUserName)) {
                        profileController.updateUserName(userId, newUserName);
                        userNameValid = true;
                    } else {  
                        System.out.println("UserName is already exist Enter a new one");
                    }
                }                
                break;
            
            case Constants.UPDATE_BIO:
                System.out.print("Enter your Bio :");
                scanner.nextLine();
                String bio = scanner.nextLine();
                profileController.updateBio(userId, bio);            
                break;

            case Constants.EXIT_UPDATEPAGE:
                updatePage = false;
                break;

            default:
                updatePage = false;
                break;
            }
        }

        
    }

    /**
     * Shows the profile of the user
     * 
     * @param userId userId of the user
     */
    private void showProfile(String userId) {
        System.out.println(profileController.getProfile(userId));
    }
    
    private void showPostByUserName(String userId) {
        String userName = profileController.getUserName(userId);
        System.out.println(postController.getPostByUserName(userName)); 
    }
    
    private void deletePost() {
        String postId;
        System.out.print("Enter the PostId : ");
        postId = scanner.nextLine();

        if (postController.deletePost(postId)) {
            System.out.println("Post Deleted ..");
        } else {
            System.out.println("Something went wrong..");
        }
    }
   

    /**
     * Shows the profilepage of the user
     * 
     * @param userId userId of the user
     */
    public void displayProfilePage(String userId) {
        int selectedOption; 
        boolean profilePage = true;
        StringBuilder profileMessage = new StringBuilder();
        profileMessage.append("\nEnter ").append(Constants.UPDATE_PROFILE)
                      .append(" --> To update Profile").append("\nEnter ")
                      .append(Constants.DELETE_POST).append("--> To delete the post ")
                      .append("\nEnter ").append(Constants.EXIT_PROFILEPAGE)
                      .append(" --> To Exit");               

        while (profilePage) {   
            showProfile(userId); 
            showPostByUserName(userId);
            System.out.println(profileMessage);
            selectedOption = scanner.nextInt();
            scanner.skip("\r\n");

            switch (selectedOption) { 
            case Constants.UPDATE_PROFILE:
                updateProfile(userId);
                break;

            case Constants.DELETE_POST:
                deletePost();
                break;
           
            case Constants.EXIT_PROFILEPAGE:
                profilePage = false;
                break;

            default:
                System.out.println("You entered wrong option");
            }
        }  
    }

} 
    
