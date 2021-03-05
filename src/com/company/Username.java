package com.company;

public class Username {
    String _userName;
    public Username(String username){
        _userName = username;
    }

    public  boolean checkValidation() {
        String copyUserName;
        String newCopy = "";
        int count = 0;
        for(char c : _userName.toCharArray()){ // count the number of times the char '_' is written in the username
            if(c == '_'){
                count++;
            }
        }
        if (count == 0 || count == 1){ //valid username only includes one or zero '_' char.

            if (_userName.contains("_")) {

                copyUserName = _userName;
                newCopy = copyUserName.replace("_", "");
                System.out.println(newCopy);

                for (char c : newCopy.toCharArray()) {
                    if (Character.isLetterOrDigit(c) == false) {
                        return false;
                    }
                }
            } else
                for (char c : newCopy.toCharArray()) {
                    if (Character.isLetterOrDigit(c) == false) {
                        return false;
                    }
                }

            return true;

        } else
            return false;

    }
}
