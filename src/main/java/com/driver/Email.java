package com.driver;

import static java.lang.Character.*;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(this.password)) {
            if(isNewPasswordValid(newPassword)) {
                this.password = newPassword;
            }
        }
    }
    private boolean isNewPasswordValid(String newPasswordCheck) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;
        int minLength = 8;
        if(newPasswordCheck.length() < minLength) {
            return false;
        }
        for(int i = 0; i < newPasswordCheck.length(); i++) {
            char c = newPasswordCheck.charAt(i);
            if(isUpperCase(c)) {
                upperCase = true;
            } else if(isLowerCase(c)) {
                lowerCase = true;
            } else if(isDigit(c)) {
                digit =true;
            } else {
                // for special character
                specialChar = true;
            }
        }
        if(upperCase && lowerCase && digit && specialChar) {
            return true;
        }
        return false;
    }
}
