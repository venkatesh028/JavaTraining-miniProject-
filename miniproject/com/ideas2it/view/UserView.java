package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.UserController;
import com.ideas2it.constant.Constants;
import com.ideas2it.model.User;
import com.ideas2it.model.Profile;

/**
 * Shows the home page to the user based on the user option
 * it takes to the further pages
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM 
 */
public class UserView {
    private Scanner scanner;
    private UserController userController;
    private String userId;
    private FeedView feedView;
    
    public UserView() {
        this.scanner = new Scanner(System.in);
        this.userController = new UserController();
        this.feedView = new FeedView();
    }


    /** 
     * Gets the emailId and password from the user
     * and pass data to the validation based on result 
     * values are stored
     */ 
    public void login() {
        String email;
        String password;
        boolean isAccountExist = false;
    
        while (!isAccountExist) {
            System.out.print("Enter your emailId : ");
            email = scanner.next(); 
            System.out.print("Enter your password : ");
            password = scanner.next();
 
            if (userController.isEmailExist(email)) {               
                if (userController.isValidCredentials(email, password)) {
                    feedView.showNewsFeed(userController.getUserId(email));
                    isAccountExist = true;
                } else {
                    System.out.println("Invalid password try again ");
                }                   
            } else {
                System.out.println("There is no account with this mailID ");
                isAccountExist = true;
            }
        } 
    }    
    
    /**
     * Get the datails from the user
     * and pass the data to the validation and based on result
     * the account is created
     */
    public void createAccount() {
        User user = new User();
        Profile profile = new Profile();
        String email;
        String password; 
        String userName = "";  
        boolean isEmailValid = false;
        boolean isPasswordValid = false;
        boolean isUserNameValid = false;     
        System.out.print("Enter your name : ");
        user.setName(scanner.next());      
    
        while (!isEmailValid) {
            System.out.print("Enter your emailId : ");
            email = scanner.next();

            if (userController.isValidEmail(email)) {
                if (!userController.isEmailExist(email)) {
                    user.setEmail(email);
                    isEmailValid = true;
                } else {
                    System.out.println("Email Already exist");
                }                
            } else {
                System.out.println("Invalid email format");     
            }  
        }

    
        while (!isPasswordValid) {
            System.out.print("Enter your password : ");
            password = scanner.next();
            
            if (userController.isValidPassword(password)) {
                user.setPassword(password);
                isPasswordValid = true;
            } else { 
                System.out.println("Invalid your password must"
                                     + " contain (a-ZA-Z0-9) "
                                     + " and Any Special Character "
                                     + "range must be 8-20");    
            }            
        }    

        System.out.println("Set user name to keep your account unique");

        while (!isUserNameValid) {
            System.out.print("UserName : ");
            userName = scanner.next();
            
            if (!userController.isUserNameExist(userName)) {
                profile.setUserName(userName);
                isUserNameValid = true;    
            } else {
                System.out.println("UserName is already exist Enter a new one");                
            } 
        }          
        user.setProfile(profile);

        if (userController.create(user) == null) { 
            userId = userController.getUserId(user.getEmail());  
                
            System.out.println("Account Created Succesfully");
            feedView.showNewsFeed(userId);
        } else {
            System.out.println("This email Id is alredy exist");
        }                          
    } 
    
    /**  
     * Shows the home page to the user 
     */
    public void showHomePage(){
        int selectedOption;
        boolean isAppRunning = true;
        StringBuilder statement = new StringBuilder();
        statement.append("\nEnter ").append(Constants.CREATE_ACCOUNT)
                 .append(" --> To Create a new account ").append("\nEnter ")
                 .append(Constants.LOGIN).append(" --> To login ")
                 .append("\nEnter ").append(Constants.EXIT_HOMEPAGE)
                 .append(" --> To quit ");
    
        while (isAppRunning) {
            System.out.println(statement);
            selectedOption = scanner.nextInt();

            switch (selectedOption) {
            case Constants.CREATE_ACCOUNT:
                createAccount();
                break;

            case Constants.LOGIN:
                login();
                break;

            case Constants.EXIT_HOMEPAGE:
                isAppRunning = false;
                break;

            default:
                System.out.println("you entered wrong choice "); 
            }
            
        }
        
    }
}
    
    

