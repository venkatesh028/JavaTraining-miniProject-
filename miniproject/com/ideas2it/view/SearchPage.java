package com.ideas2it.view;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.ideas2it.model.Profile;
import com.ideas2it.constant.Constants;
import com.ideas2it.controller.ProfileController;

public class SearchPage {
    Scanner scanner;
    ProfileController profileController;
    
    public SearchPage() {
        this.scanner  = new Scanner(System.in);
        this.profileController = new ProfileController();
    }

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
                showUserProfile(search());
                break;

            case Constants.TO_GO_BACK:
                isGoBack = true;
                break;
             
            default:
                break;               
            }
        }
      
    }
    
    public void showUserProfile(Profile profile) {
        int selectedOption;
        StringBuilder profileMessage = new StringBuilder();
        Profile userProfile = profile;
        System.out.print(profile);
        profileMessage.append("\nEnter ").append(Constants.ADD_FRIEND)
                      .append(" --> To give friend request ")
                      .append("\nEnter ").append(Constants.REMOVE_FRIEND)
                      .append(" --> To remove the friend request ");
       System.out.println(profileMessage); 
       selectedOption = getInput();

       switch (selectedOption) {
       case Constants.ADD_FRIEND:               
           break;

       case Constants.REMOVE_FRIEND:
           break;

       }
    }
    
    /**
     * Search the user based on the username entered by the user
     * 
     * @return profile profile based on the username
     */
    public Profile search() {
        String userName;
        System.out.print("Enter the username : ");
        userName = scanner.next();
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