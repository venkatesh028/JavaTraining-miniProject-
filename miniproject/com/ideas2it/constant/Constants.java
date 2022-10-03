package com.ideas2it.constant;

/**
 * Contain the Format of the email, Password and contain all the constant values
 *
 * @version 1.0 
 * @author Venkaetsh Tm
 */
public class Constants {
    public final static String EMAIL_FORMAT = "^[a-zA-Z0-9][a-zA-Z0-9.]{3,30}@[a-zA-Z0-9]+\\.[a-zA-Z0-9.]{3,}$";
    public final static String PASSWORD_FORMAT = "^[a-zA-Z0-9]{4,9}[@$&*]{1,}[0-9]{1,3}";
    public final static String PHONE_NUMBER_FORMAT = "(\\+91-)?[6-9][0-9]{9}";
    public final static String NAME_FORMAT = "[a-zA-Z\\s]{3,20}";   

    public final static int CREATE_ACCOUNT = 1;
    public final static int LOGIN = 2;
    public final static int EXIT_HOMEPAGE = 3;

    public final static int SHOW_POST = 1;
    public final static int SHOW_PROFILE = 2;
    public final static int SHOW_NOTIFICATION = 3;
    public final static int SHOW_SEARCH  = 4;
    public final static int SHOW_SETTING = 5;
    public final static int LOGUT = 6;
    
    public final static int UPDATE_PROFILE = 1;
    public final static int DELETE_POST =2;
    public final static int EXIT_PROFILEPAGE = 3;

    public final static int UPDATE_USERNAME = 1;
    public final static int UPDATE_BIO = 2;
    public final static int EXIT_UPDATEPAGE = 3;

    public final static int ADDPOST = 1;
    public final static int LIKE = 2;
    public final static int COMMENT = 3;
    public final static int EXIT_POSTPAGE = 4;   
   
    public final static int SHOW_PERSONAL_INFO = 1;
    public final static int UPDATE_PERSONAL_INFO = 2;
    public final static int DELETE_ACCOUNT = 3;
    public final static int EXIT_SETTING = 4;

    public final static int UPDATE_NAME = 1;
    public final static int UPDATE_EMAIL = 2;
    public final static int UPDATE_GENDER = 3;
    public final static int UPDATE_DOB = 4;
    public final static int UPDATE_PHONENUMBER = 5;
    public final static int UPDATE_PASSWORD = 6;
    public final static int EXIT_UPDATE = 7;
    
    public final static int SEARCH = 1;
    public final static int TO_GO_BACK = 2;
    
    public final static int ADD_FRIEND = 1;
    public final static int REMOVE_FRIEND = 2;
    
}