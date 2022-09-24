package com.ideas2it.view;

import java.util.Scanner;
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

    /**
     * Creates a new object for the FeedView and initialize the feilds
     * of that class
     */    
    public FeedView() {
        this.postView = new PostView();
        this.settingView = new SettingView();
        this.scanner = new Scanner(System.in);
        this.profileView = new ProfileView();
    }
    
    /**
     * Shows the newsfeed page
     *
     * @param userId
     */
    public void showNewsFeed(String userId) {
        int action;
        boolean newsFeedRunning = true;
        StringBuilder statement = new StringBuilder();
        statement.append("\nEnter ").append(Constants.SHOW_POST)
                 .append(" --> To View Post ").append("\nEnter ")
                 .append(Constants.SHOW_PROFILE)
                 .append(" --> To view your profile ")
                 .append("\nEnter ").append(Constants.SHOW_SETTING)
                 .append(" --> To go to setting ")
                 .append("\nEnter ").append(Constants.LOGUT)
                 .append(" --> To Logout");
    
        while (newsFeedRunning) {
            System.out.println(statement);
            action = scanner.nextInt();
            scanner.skip("\r\n");
            
            switch (action) {
            case Constants.SHOW_POST:
                postView.displayPost(userId);
                break;
            
            case Constants.SHOW_PROFILE:
                profileView.displayProfilePage(userId);
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
}