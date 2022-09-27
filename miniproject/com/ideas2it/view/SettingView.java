package com.ideas2it.view;

import java.util.Scanner;

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
        userController.deleteAccount(userId);
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
        User user = userController.getUserById(userId);

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
            selectedOption = scanner.nextInt();
            scanner.skip("\r\n");

            switch (selectedOption) {
            case Constants.UPDATE_NAME:
                System.out.print("Enter Name : ");
                String name = scanner.nextLine();
                user.setName(name);
                break;

            case Constants.UPDATE_EMAIL:
                boolean emailValid = false;
                String email;

                while (!emailValid) {
                    System.out.print("Enter your emailId : ");
                    email = scanner.next();

                    if (userController.isValidEmail(email)) {
                        if (!userController.isEmailExist(email)) {
                            userController.updateLoginCredentials(user.getEmail(), email);
                            user.setEmail(email);
                            emailValid = true;
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
                System.out.print("Enter DOB : ");
                String dateOfBirth = scanner.next();
                user.setDateOfBirth(dateOfBirth);
                break;

            case Constants.UPDATE_PHONENUMBER:
                System.out.print("Enter Phone number : ");
                String phoneNumber = scanner.next();
                user.setPhoneNumber(phoneNumber);
                break;

            case Constants.EXIT_UPDATE:
                userController.updateUser(userId, user);
                update = false;
                break;
     
            default:
                userController.updateUser(userId, user);            
            }
        }
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
                      .append(Constants.EXIT_SETTING)
                      .append(" -->To View Exit");

        while (settingPage) {
            System.out.print(settingMessage);
            selectedOption = scanner.nextInt();
            
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
             
            case Constants.EXIT_SETTING:
                settingPage = false; 
                break;
            }
            
        }
    }
}