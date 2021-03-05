package com.company;

import java.util.ArrayList;
//This is an Email class and it makes sure it contains valid email
//Valid email format is lyslukuka@gmail.com, lys-lukuka@gmail.com, lys-paul.lukuka@gmail.com, lyslukuka12@gmail.com
// lys-paul.lukuka1@gmail.com
public class Email {
    private String _email;
    private boolean check = false;
    boolean  checkLetter;
    public Email(String email) {
        _email = email;
    }
    public boolean checkCharacters(){ // This method checks if email includes valid characters

        char[] xArray = _email.toCharArray();
        ArrayList<Character> copyEmail = new ArrayList<Character>();

        if (_email == null){ // return false if string is null
            return false;

        }
        if(_email.contains("@") && _email.contains(".")){ // checks if email contains @ and .
            for(char c : xArray){
                copyEmail.add(c);
            }
            //System.out.println(checkCharH());
            if (checkCharH() == true){
               // System.out.println("CONTAINS");
                for (int i=0; i < copyEmail.size(); i++){
                    if (copyEmail.get(i) == '-' || copyEmail.get(i) == '_' || copyEmail.get(i) == '@' || copyEmail.get(i) == '.'){
                        copyEmail.remove(i);
                    }
                }

            } else if (checkCharH() == false){
                for (int i=0; i < copyEmail.size(); i++){
                    if (copyEmail.get(i) == '@' || copyEmail.get(i) == '.'){
                        copyEmail.remove(i);
                    }
                }
            }

            String conversion = copyEmail.toString(); //convert the copyEmail to a string
            String newConversion = conversion.substring(1, conversion.length() - 1); //removes the [] from the string
            String secondNewConversion = newConversion.replaceAll(", ", ""); //removes the comma and space from the string

            for (int i=0; i < secondNewConversion.length(); i++){

                if (Character.isLetterOrDigit(secondNewConversion.charAt(i)) == false){ //checks if string character is neither a letter or digit
                    System.out.println(secondNewConversion.charAt(i) + " is an invalid char");
                    return false;
                }

            }
            System.out.println(secondNewConversion + " is a valid char");
            return true ;
             //return true if email has valid letters and digits
        } else
            System.out.println("INVALID CHARACTER");
            return false; // returns false if email does not include '@' and '.'

    }
    public boolean checkCharH(){ //checks if email contain  char '-' or '_'
        boolean characterCheck;
        if(_email.contains("-") && _email.contains("_")){
            return true;
        } else if(_email.contains("-") || _email.contains("_")){
            return true;

        } else
        return false;
    }
    public boolean checkEmail(){
       char [] email = _email.toCharArray();
       int countDot = 0;
       boolean secondCheck = false;
       ArrayList <Integer> position = new ArrayList<Integer>();

        if (checkCharacters() == true) {

                    if (checkCharH() == true){
                    checkLetter = true;
                }
                else
                    checkLetter = false;

            for (int i = 0; i < email.length; i++) {
                if (email[i] == '.') {
                    countDot += 1;
                    position.add(i);
                }
            }

            if (checkLetter == true) {

                if (_email.indexOf("_") > _email.indexOf("@")) {
                    check = false;
                }
                if (countDot > 1 && countDot <= 2) {
                    if (position.get(0) > _email.indexOf("@")) {
                        check = false;
                    }   else if (position.get(1) < _email.indexOf("@")) {
                        check = false;
                    }   else if ((_email.indexOf("@") - 1) == position.get(0) || (position.get(1) - 1) == _email.indexOf("@")) {
                        check = false;
                    }   else if (_email.indexOf("_") > _email.indexOf("@")){
                        check = false;
                    }
                    else
                        check = true;

                } else if (_email.indexOf("@") < _email.indexOf(".")) {

                    if (position.get(1) - 1 == _email.indexOf("@")) {
                        check = false;
                    } else
                        check = true;
                } else if (_email.indexOf("@") - 1 == _email.indexOf("-") || _email.indexOf("@") - 1 == _email.indexOf("_")){
                    check = false;
                }
            } else if (checkLetter == false) {
                if (countDot > 1 && countDot <= 2) {
                    if (Character.isDigit(_email.charAt(0)) == true || Character.isDigit(_email.charAt(_email.length() - 1)) == true){
                        check = false;
                    } else if (position.get(0) > _email.indexOf("@")) {
                        check = false;
                    } else if (position.get(1) < _email.indexOf("@")) {
                        check = false;
                    } else if ((_email.indexOf("@") - 1) == position.get(0) || (position.get(1) - 1) == _email.indexOf("@")) {
                        check = false;
                    } else
                       check = true;
                } else if (_email.indexOf("@") < _email.indexOf(".")) { //return false if email is in format email@.gmailcom and true if format is email@gmail.com
                    int a = _email.indexOf("@");
                    int b = _email.length() - a;
                    String cutEmail = _email.substring(a, _email.length());
                    for (int i=0; i < cutEmail.length(); i++){

                        if (Character.isDigit(cutEmail.charAt(i))){
                            secondCheck = true;
                        }
                    }
                      if (Character.isDigit(_email.charAt(0)) == true || secondCheck == true){ //checks if the email contains a number at the beginning or after the @
                        check = false;
                    } else if (position.get(1) - 1 == _email.indexOf("@")) {
                        check = false;
                    } else
                        check = true;
                } else
                    check = false;

            } else
            check = false;
        }
        else {
            check = false;
        }
            return check;
    }
}
