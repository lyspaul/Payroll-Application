package com.company;

public class EmployeeID {
    private String _employeeID;
    public EmployeeID (String employeeID) {
        _employeeID = employeeID;
    }

    public  boolean checkValidation() {

        for (char c : _employeeID.toCharArray()) {
            if (Character.isLetterOrDigit(c) == false){
                return false;
            }
        }
        return true;
    }
}
