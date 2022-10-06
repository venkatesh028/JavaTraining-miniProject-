package com.ideas2it.view;

import java.util.Scanner;
import java.lang.Exception;  
import java.util.InputMismatchException;
import java.time.LocalDate;

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
    private UserController userController;
    private String userId;
    private FeedView feedView;
    private Scanner scanner;

    public UserView() {
        this.userController = new UserController();
        this.scanner = new Scanner(System.in);
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
        int age;
        
        user.setName(getName());   
        user.setDateOfBirth(getDateOfBirth());          
        age = userController.calculateAge(user.getDateOfBirth());

        if (age>=18) {
            user.setAge(age );
            user.setEmail(getEmail());  
            user.setPassword(getPassword());
            System.out.println("Set user name to keep your account unique"); 
            profile.setUserName(getUserName());       
            user.setProfile(profile);

            if (userController.create(user) == null) { 
                userId = userController.getUserId(user.getEmail());                  
                System.out.println("Account Created Succesfully");
                feedView.showNewsFeed(userId); 
            } else {
                System.out.println("This email Id is alredy exist");
            }  
        
        } else {
            System.out.println("You are not elibile to create a account");
        }                        
    } 
    
    /**  
     * Shows the home page to the user 
     */
    public void showHomePage() {
        int selectedOption;
        boolean isPageActive = true;
        StringBuilder statement = new StringBuilder();
        statement.append("\nEnter ").append(Constants.CREATE_ACCOUNT)
                 .append(" --> To Create a new account ").append("\nEnter ")
                 .append(Constants.LOGIN).append(" --> To login ")
                 .append("\nEnter ").append(Constants.EXIT_HOMEPAGE)
                 .append(" --> To quit ");
       
        while (isPageActive) {   
            boolean a = false;                     
            System.out.println(statement);
            selectedOption = getInput();      

            switch (selectedOption) {
            case Constants.CREATE_ACCOUNT:
                createAccount();
                break;

            case Constants.LOGIN:
                login();
                break;

            case Constants.EXIT_HOMEPAGE:
                isPageActive = false;
                break;

            default:
                System.out.println("you entered wrong choice "); 
            }            
        }       
    }
    
    /** 
     * Get name from the user
     * And validate it 
     * 
     * @return name name of the user if it is valid
     */
    private String getName() {
        boolean isValid = false;
        String name = "";
 
        while(!isValid) {
            System.out.print("\nEnter your Name : ");
            name = scanner.nextLine();
            System.out.println(name);
            isValid = userController.isValidName(name);
        }
        return name;
    }
    
    /**
     * Get dateofBirth of the user
     * And Validate it
     *
     * @return dateOfBirth if it is valid 
     */
    private LocalDate getDateOfBirth() {
        boolean isValid = false;
        String dateOfBirth= "";

        while (!isValid) {
            System.out.print("Enter the DateofBirth in given format (yyyy-mm-dd) : ");
            dateOfBirth = scanner.nextLine();
            
            if (userController.isValidDateOfBirth(dateOfBirth)) {                
                isValid= true;
            } else {
                System.out.println("Invalid date");
            }
        } 
        return LocalDate.parse(dateOfBirth);        
    }
    
    /**
     * Get email of the user 
     * And validate it
     *
     * @return email email of the user if it is valid
     */
    private String getEmail() {
        boolean isValid = false;
        String email = "";

        while (!isValid) {
            System.out.print("Enter your emailId : ");
            email = scanner.nextLine();

            if (userController.isValidEmail(email)) {
                if (!userController.isEmailExist(email)) {
                    isValid = true;
                } else {
                    System.out.println("Email Already exist");
                }                
            } else {
                    System.out.println("Invalid email format");     
            }  
        }
        return email;
    }
    
    /**
     * Get the password of the user
     * And validate it
     * 
     * @return password  password of the user if it is valid
     */
    private String getPassword() { 
        boolean isValid = false;
        String password = "";
         
        while (!isValid) {
            System.out.print("Enter your password (a-ZA-Z0-9 and Special Character) : ");
            password = scanner.nextLine();
            
            if (userController.isValidPassword(password)) {
                isValid = true;
            } else {
                System.out.println("Invalid your password must "
                                         + "contain (a-ZA-Z0-9) "
                                         + "and Any Special Character "
                                         + "range must be 8-20");    
            }            
        }  
        return password;        
    }
    
    /**
     * Get username of the user
     * And validate it
     * 
     * @return userName username of the user if it is valid
     */
    private String getUserName() {
        boolean isValid = false;
        String userName = "";

        while (!isValid) {
            System.out.print("UserName : ");
            userName = scanner.nextLine();
            
            if (userController.isValidUserName(userName)) {
                if (!userController.isUserNameExist(userName)) {
                    isValid = true;    
                } else {
                    System.out.println("UserName is already exist Enter a new one");
                }
            } else {
                System.out.println("Invalid username");                
            } 
        }  
        return userName;        
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
    
    

