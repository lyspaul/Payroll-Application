package com.company;

import java.awt.*;

//This class checks whether username and password is valid or not
public class Operations {
    public boolean usernameCheck(String username) {
        boolean check = false;
        //This checks if the username only contains digit or length
        if (!username.contains(" ")) {
            for (int i = 0; i < username.length(); i++) {
                if ((Character.isLetterOrDigit(username.charAt(i)))) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }
        else
        {
        check = false;
        }

        return check;
    }

    public boolean passwordValidCheck(String password){
        boolean checkPassword =true;
        if(password.contains(" ")) {
            checkPassword = false;
        }
        else {
            checkPassword = true;
        }
        return checkPassword;
    }


}
