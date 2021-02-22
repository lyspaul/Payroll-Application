package com.company;

public class Email {
    private String _email;
    private boolean check = false;
    public Email(String email) {
        _email = email;
    }

    public boolean checkEmail(){
        if (_email.contains("@") && _email.contains(".")) {
            check = true;

        } else {
            check = false;
        }
            return check;
    }
}
