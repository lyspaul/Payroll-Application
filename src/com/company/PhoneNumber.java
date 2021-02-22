package com.company;

public class PhoneNumber {
    String _phone;
    boolean checkPhone = true;

    public PhoneNumber(String phone){
        _phone = phone;
        //getPhone();
    }
    public Boolean getPhone() {
        if(_phone.length() != 10){
            System.out.println("Please Enter a valid phone number");
            checkPhone = false;
        } else if (_phone.contains("(") && _phone.contains(")") && _phone.contains("-")){
            if (_phone.indexOf("(") != 0 && _phone.indexOf(")") != 0){

            }
        }
        return checkPhone;
    }
}
