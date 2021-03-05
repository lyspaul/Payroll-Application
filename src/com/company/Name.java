package com.company;

public class Name {
    private String _firstName;
    private String _lastName;
    private boolean check;
    private char[] checkLettersOnly;
    private char[] CheckLettersOnlyLast;
    public Name (String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
        checkLettersOnly = firstName.trim().toLowerCase().toCharArray();
        CheckLettersOnlyLast = lastName.trim().toLowerCase().toCharArray();
    }

    public boolean CheckFirstName (){

        for(int j=0; j < checkLettersOnly.length; j++){
            char value = checkLettersOnly[j];

           if (value < 'a' || value > 'z'){
               check = false;
           } else
               check = true;
           // System.out.println("Value is valid");
        }
    return check;
    }

    public boolean CheckLastName (){

        for(int j=0; j < CheckLettersOnlyLast.length; j++){
            char value = CheckLettersOnlyLast[j];
            if (value < 'a' || value > 'z'){
                check = false;
            } else
                check = true;
        }
        return check;
    }
}
