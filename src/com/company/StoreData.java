package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StoreData extends DataBase {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String employeeID;
    private String username;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;

    public StoreData (String _firstName, String _lastName, String _emailAddress, String _employeeID
    , String _username, String _password, String _address, String _city, String _state, String _zipcode,
                      String _phoneNumber) {

        firstName = _firstName;
        lastName = _lastName;
        emailAddress = _emailAddress;
        employeeID = _employeeID;
        username = _username;
        password = _password;
        address = _address;
        city = _city;
        state = _state;
        zipcode = _zipcode;
        phoneNumber = _phoneNumber;
    }

    public void storeDataMySQL() throws Exception {
        Connection conn = getConnection();
        PreparedStatement insertValues = conn.prepareStatement
                ("INSERT INTO employee_info VALUES ('1','"+firstName+"', '"+lastName+"', '"+employeeID+"', '"+username+"', '"+password+"', '"+emailAddress+"', '"+phoneNumber+"', '"+address+"', '"+city+"', '"+state+"', '"+zipcode+"' )");
        insertValues.executeUpdate();

                //CREATE TABLE employeeinfo1 (EmployeeID varchar(8), first_Name varchar(200), last_Name varchar(200),
        //username varchar(100), user_password varchar(200), email_address varchar(200), phone_number varchar(50),
        //address varchar(200), city varchar(200), state varchar(200), zipcode varchar(200), _key INT PRIMARY KEY);
    }
}
