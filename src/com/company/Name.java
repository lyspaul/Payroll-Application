package com.company;

public class Name {
    private String _name;
    private boolean check;
    private char[] checkLettersOnly;
    public Name (String name) {
        _name = name;
        checkLettersOnly = name.trim().toLowerCase().toCharArray();
    }

    public boolean checkName (){

        for(int j=0; j < checkLettersOnly.length; j++){
            char value = checkLettersOnly[j];
           if (value <= 'a' && value >= 'z'){
               check = false;
           } else
               check = true;
        }
    return check;
    }
}
