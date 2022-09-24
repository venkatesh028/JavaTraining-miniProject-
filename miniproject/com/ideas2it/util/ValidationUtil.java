package com.ideas2it.util;

import com.ideas2it.constant.Constants;

/**
 * Contain the validation part 
 *
 * @version 1.0 22-SEP-2022
 * @author Venkatesh TM
 */
public class ValidationUtil {
    
    /** 
     * Check the given email matches to the given format 
     * 
     * @param  email   email need to be validated 
     * @return boolean true if the given data matches the format else false
     */
    public boolean isValidEmail(String email) {
        return email.matches(Constants.emailFormat);
    }

    /** 
     * Check the given password matches to the given format 
     * 
     * @param  password password need to be validated 
     * @return boolean  true if the given data matches the format else false
     */
    public boolean isValidPassword(String password) {
        return password.matches(Constants.passwordFormat);
    }
}