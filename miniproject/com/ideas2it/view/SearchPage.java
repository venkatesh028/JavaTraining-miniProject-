package com.ideas2it.view;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;

import com.ideas2it.model.Profile;
import com.ideas2it.constant.Constants;
import com.ideas2it.controller.ProfileController;
import com.ideas2it.controller.NotificationController;
import com.ideas2it.model.Notification;
import com.ideas2it.controller.PostController;

/**
 * Search the user and give friend request 
 *
 * @version 1.0 01-OCT-2022
 * @author Venkatesh TM
 */
public class SearchPage {
    Scanner scanner;
    ProfileController profileController;
    ProfileView profileView;
    NotificationController notificationController;

    public SearchPage() {
        this.scanner  = new Scanner(System.in);
        this.profileController = new ProfileController();
        this.profileView = new ProfileView();
        this.notificationController = new NotificationController();
    }
    
    /**
     * Shows the search page where you can search users
     *
     * @param userId  userid of the person 
     */ 
    public void showSearchPage(String userId){
        boolean isGoBack = false;  
        int selectedOption;

        StringBuilder searchMessage = new StringBuilder();
        searchMessage.append("\nEnter ").append(Constants.SEARCH)
                     .append(" --> To search the users ")
                     .append("\nEnter ").append(Constants.TO_GO_BACK)
                     .append(" --> To go back ");

        while (!isGoBack) {
            System.out.print(searchMessage);
            selectedOption = getInput();

            switch (selectedOption) {
            case Constants.SEARCH:
                Profile profile = search(userId);
                if (profile != null) {
                    if (profile.getUserName().equals(profileController.getUserName(userId))) {
                        profileView.displayProfilePage(userId);
                    } else {
                        showUserProfile(profile, userId);
                    }
                } else {
                        System.out.println("There is no account with this username ");
                }
                break;

            case Constants.TO_GO_BACK:
                isGoBack = true;
                break;
             
            default:
                break;               
            }
        }
      
    }
    
    /**
     * Shows the profile of the user who got searched
     *
     * @param profile profile of the user who got searched
     */
    public void showUserProfile(Profile profile, String userId) {
        int selectedOption;
        StringBuilder profileMessage = new StringBuilder();
        String requestedUser = profileController.getUserName(userId);      
        PostController postController = new PostController();

        if (!profile.getIsPrivate()) {
            System.out.print(profile);
            System.out.print(postController.getPostByUserName(profile.getUserName()));
        } else {
            System.out.print(profile);
            System.out.print("Account is private ");
        }

        profileMessage.append("\nEnter ").append(Constants.ADD_FRIEND)
                      .append(" --> To give friend request ")
                      .append("\nEnter ").append(Constants.REMOVE_FRIEND)
                      .append(" --> To remove the friend request ")
                      .append("\nEnter ").append(Constants.BACK)
                      .append(" --> To go back ");

       System.out.println(profileMessage); 
       selectedOption = getInput();      
       
       switch (selectedOption) {
       case Constants.ADD_FRIEND:
           Notification notification = new Notification(requestedUser, LocalDate.now());
           notificationController.addNotifications(profile.getUserName(), notification);      
           break;

       case Constants.REMOVE_FRIEND:
           break;

       case Constants.BACK:
           break;

       }
    }
    
    /**
     * Search the user based on the username entered by the user
     * 
     * @return profile profile based on the username
     */
    public Profile search(String userId) {
        String userName;
        System.out.print("Enter the username : ");
        userName = scanner.nextLine();

        return profileController.getUserProfile(userName);
    }

    /**
     * Get input form the user 
     * 
     * @return input input given by the user
     */
    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        try{
            input = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Enter Only Number not String ");
            return 0;
        }
        return input; 
    }

}