package com.ideas2it.view;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;

import com.ideas2it.constant.Constants;
import com.ideas2it.model.User;
import com.ideas2it.controller.UserController;

/**
 * Shows the setting page to the user
 *
 * @version 1.0 22-SEP-2022
 * @authro  Venkatesh TM
 */
public class SettingView {
    private UserController userController;
    private Scanner scanner = new Scanner(System.in);

    public SettingView() {
        this.userController = new UserController();
    }
     
    /**
     * Delete the account of the user 
     *
     * @param userId userId of the user
     */
    private void deleteAccount(String userId) {
        userController.delete(userId);
    }
    
    /**
     * Shows the personal information of the user
     * 
     * @param userId userId of the user
     */
    private void showPersonalInfo(String userId) {
        System.out.println(userController.showPersonalInfo(userId));            
    }
    
    /**
     * Shows the option to update the personal information of the user
     *
     * @userId userId of the user
     */
    private void updatePersonalInfo(String userId) {
        StringBuilder updateMessage = new StringBuilder();
        int selectedOption;
        boolean update = true;
        User user = userController.getById(userId);

        updateMessage.append("\nEnter ").append(Constants.UPDATE_NAME)
                     .append(" --> To update Name ").append("\nEnter ")
                     .append(Constants.UPDATE_EMAIL)
                     .append(" --> To update email").append("\nEnter ")
                     .append(Constants.UPDATE_GENDER)
                     .append(" --> To update gender ").append("\nEnter ")
                     .append(Constants.UPDATE_DOB)
                     .append(" --> To update DOB ").append("\nEnter ")
                     .append(Constants.UPDATE_PHONENUMBER)
                     .append(" --> To update Phonenumber ").append("\nEnter")
                     .append(Constants.EXIT_UPDATE)
                     .append(" --> To exit ");
        
        while(update) {
            System.out.println(updateMessage);
            selectedOption = getInput();

            switch (selectedOption) {
            case Constants.UPDATE_NAME:
                user.setName(getName());
                break;

            case Constants.UPDATE_EMAIL:
                boolean emailValid = false;
                String email;

                while (!emailValid) {
                    System.out.print("Enter your emailId : ");
                    email = scanner.next();

                    if (userController.isValidEmail(email)) {
                        if (!userController.isEmailExist(email)) {
                            if (userController.updateLoginCredentials(user.getEmail(), email) == null) {
                                user.setEmail(email);
                                emailValid = true;
                            } else {
                                System.out.print("Something went wrong not updated ");
                            }
                        } else {
                            System.out.println("Email Already exist");
                        }                
                    } else {
                        System.out.println("Invalid email format");     
                    }  
                }
                break;

            case Constants.UPDATE_GENDER:
                System.out.print("Enter Gender : ");
                String gender = scanner.next();
                user.setGender(gender);
                break;

            case Constants.UPDATE_DOB:
                String dateOfBirth;
                boolean isValidDateOfBirth = false;

                while (!isValidDateOfBirth) {
                    System.out.print("Enter the DateofBirth : ");
                    dateOfBirth = scanner.next();
                    int age;
                    if (userController.isValidDateOfBirth(dateOfBirth)) {
                        age = userController.calculateAge(LocalDate.parse(dateOfBirth));
                        if (age>=18){
                            user.setDateOfBirth(LocalDate.parse(dateOfBirth));
                            user.setAge(age);
                            isValidDateOfBirth = true;
                        } else {
                            System.out.println("Not eligible to have a account");
                        }
                    } else {
                        System.out.println("Invalid date."
                                           +"\nEnter in given format (yyyy-mm-dd)");
                    }
                }   
                break;

            case Constants.UPDATE_PHONENUMBER:
                boolean isValidNumber = false;
                while (!isValidNumber) {
                    System.out.print("Enter Phone number : ");
                    String phoneNumber = scanner.next();

                    if (userController.isValidPhoneNumber(phoneNumber)) {  
                        user.setPhoneNumber(phoneNumber); 
                        isValidNumber = true;
                    } else {
                        System.out.println("Enter in valid foramt (+91-6...)");
                    }
                }                
                break;

            case Constants.EXIT_UPDATE:
                userController.update(userId, user);
                update = false;
                break;
     
            default:
                userController.update(userId, user);            
            }
        }
    }
    
    /**
     * Update the password of the user by getting new password 
     * from the user
     * 
     * @param userId id of the user
     */
    private void updatePassword(String userId) {
        User user = userController.getById(userId);
        String oldPassword;
        String newPassword;
        boolean isPasswordValid = false;
        System.out.println("Enter your old Password : ");
        oldPassword = scanner.next();
        
        if (userController.isPasswordMatches(userId, oldPassword)) {
   
            while (!isPasswordValid) {
                System.out.println("Enter the new password : ");
                newPassword = scanner.next();     
            
                if (userController.isValidPassword(newPassword)) {
                    user.setPassword(newPassword);
                    isPasswordValid = true;
                } else { 
                    System.out.println("Invalid your password must"
                                         + " contain (a-ZA-Z0-9) "
                                         + " and Any Special Character "
                                         + "range must be 8-20");   
                }            
            } 

        } else {
            System.out.println("Try to enter the correct Password ");
        }
        userController.update(userId, user);        
    }
    
    /**
     * Shows the setting page of the user 
     *
     * @param userId userid of the user
     */
    public void displaySettingPage(String userId) {
        int selectedOption;
        boolean settingPage = true;
        StringBuilder settingMessage = new StringBuilder();
        settingMessage.append("\nEnter ")
                      .append(Constants.SHOW_PERSONAL_INFO)
                      .append(" -->To View Personal Info ")
                      .append("\nEnter ")
                      .append(Constants.UPDATE_PERSONAL_INFO)
                      .append(" -->To update Personal Info ")
                      .append("\nEnter ")
                      .append(Constants.DELETE_ACCOUNT)
                      .append(" -->To Delete Account ")
                      .append("\nEnter ")
                      .append(Constants.UPDATE_PASSWORD)
                      .append(" -->To Update password ")
                      .append("\nEnter ")
                      .append(Constants.EXIT_SETTING)
                      .append(" -->To View Exit");

        while (settingPage) {
            System.out.print(settingMessage);
            selectedOption = getInput();
            
            switch (selectedOption) {
            case Constants.SHOW_PERSONAL_INFO:
                showPersonalInfo(userId);
                break;

            case Constants.UPDATE_PERSONAL_INFO:
                updatePersonalInfo(userId);
                break;

            case Constants.DELETE_ACCOUNT:
                deleteAccount(userId);
                break;
            case Constants.UPDATE_PASSWORD:
                updatePassword(userId);
                break;
            case Constants.EXIT_SETTING:
                settingPage = false; 
                break;
            }
            
        }
    }  
     
    /**
     * Getting the input from the user 
     *
     * @return input input given the user 
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
    
    /**
     * Get the name from the user
     *
     * @return name  name of the user 
     */
    private String getName() {
        boolean isValid = false;
        String name = "";
 
        while(!isValid) {
            System.out.print("Enter your Name : ");
            name = scanner.nextLine();
            isValid = userController.isValidName(name);
        }
        return name;
    }
}