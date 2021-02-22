package com.company;

public class ZipCode {
    private String _zipcode;
    private Boolean checkValid;
    private char zipcodeSplit;
    public ZipCode(String zipcode) {
        _zipcode = zipcode;
    }
    public boolean checkZipcode() {

        try {
            if (_zipcode.length() == 5 ) {
                System.out.println("Valid zipcode");
                checkValid = true;
            } else if (_zipcode.length() == 10){
                zipcodeSplit =_zipcode.charAt(5);
                if(zipcodeSplit == '-') {
                    System.out.println("Valid zipcode");
                    checkValid = true;
                }
            }
            else {
                checkValid = false;
            }

        } catch (Exception e) {
            System.out.println("yes sir");
        }

        return checkValid;
    }
}
