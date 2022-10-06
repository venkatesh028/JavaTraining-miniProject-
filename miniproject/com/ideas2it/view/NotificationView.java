package com.ideas2it.view;

import java.util.Set;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ideas2it.controller.ProfileController;
import com.ideas2it.controller.UserController;
import com.ideas2it.controller.NotificationController;
import com.ideas2it.constant.Constants;
import com.ideas2it.controller.NotificationController;
import com.ideas2it.model.Notification;


/**
 * Notification view shows the friend request received from the different users
 * User can Accept or rejecet the request based on the user wish
 *
 * @version 1.0 06-OCT-2022
 * @author Venkatesh TM
 */
public class NotificationView {
    private ProfileController profileController;
    private NotificationController notificationController;
    private UserController userController;

    public NotificationView () {
        this.profileController = new ProfileController();
        this.notificationController = new NotificationController();
        this.userController = new UserController();
    }
    
    /**
     * Shows the requests received from the users
     * 
     * @param userId   id of the user
     */ 
    public void showRequests(String userId) {
        int selectedOption;
        String userName;
        String requestedUserId = "";
        
        userName = profileController.getUserName(userId);
        Set<Notification> notifications = notificationController.getNotifications(userName); 

        StringBuilder notificationMessage = new StringBuilder();
        notificationMessage.append("\nEnter ").append(Constants.ACCEPT)
                           .append(" --> To accept friend request ")
                           .append("\nEnter ").append(Constants.REJECT)
                           .append(" --> To reject the request ")
                           .append("\nEnter ").append(Constants.SKIP)
                           .append( " --> To skip now ");     
        
        for (Notification notification : notifications) {
            System.out.println(notification);

            System.out.print(notificationMessage);
            selectedOption = getInput();

            switch(selectedOption) {
            case Constants.ACCEPT:
                requestedUserId = userController.getUserIdByUserName(notification.getUserName());
                profileController.addFriend(userId, notification.getUserName());
                profileController.addFriend(requestedUserId, userName);
                notificationController.clearNotification(userName, notification.getUserName());
                break;

            case Constants.REJECT:
                break;

            case Constants.SKIP:
                break;

            }
        }    
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