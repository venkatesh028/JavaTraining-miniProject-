package com.ideas2it.view;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.ideas2it.constant.Constants;


/**
 * Shows the feed page to user based on the user action
 * It takes to the further pages 
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class FeedView {
    private PostView postView;
    private ProfileView profileView;
    private SettingView settingView;
    private Scanner scanner;
    private SearchPage searchPage;
    private NotificationView notificationView;
    
    /**
     * Creates a new object for the FeedView and initialize the feilds
     * of that class
     */    
    public FeedView() {
        this.postView = new PostView();
        this.settingView = new SettingView();
        this.scanner = new Scanner(System.in);
        this.profileView = new ProfileView();
        this.searchPage = new SearchPage();
        this.notificationView = new NotificationView();
    }
    
    /**
     * Shows the newsfeed page
     *
     * @param userId
     */
    public void showNewsFeed(String userId){
        int action;
        Scanner scanner = new Scanner(System.in);
        boolean newsFeedRunning = true;
        StringBuilder message = new StringBuilder();
        message.append("\nEnter ").append(Constants.SHOW_POST)
               .append(" --> To View Post ").append("\nEnter ")
               .append(Constants.SHOW_PROFILE)
               .append(" --> To View your profile ")
               .append("\nEnter ").append(Constants.SHOW_NOTIFICATION)
               .append(" --> To View Notification")
               .append("\nEnter ").append(Constants.SHOW_SEARCH)
               .append(" --> To go to Search page")
               .append("\nEnter ").append(Constants.SHOW_SETTING)
               .append(" --> To go to setting ")
               .append("\nEnter ").append(Constants.LOGUT)
               .append(" --> To Logout");
    
        while (newsFeedRunning) {
            System.out.println(message);
            action = getInput();
            
            switch (action) {
            case Constants.SHOW_POST:
                postView.displayPost(userId);
                break;
            
            case Constants.SHOW_PROFILE:
                profileView.displayProfilePage(userId);
                break;

            case Constants.SHOW_NOTIFICATION:
                notificationView.showRequests(userId);
                break;

            case Constants.SHOW_SEARCH:
                searchPage.showSearchPage(userId);
                break;

            case Constants.SHOW_SETTING:
                settingView.displaySettingPage(userId);
                break;

            case Constants.LOGUT:
                newsFeedRunning = false;
                break;
            }
        }                   
    }
    
    /**
     * Get input from the user 
     * 
     * @return input 
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