package com.company;

import jdk.jfr.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LoginPage  extends JFrame  {
    Container container = getContentPane();
    String userName1, userName;
    String password;
    Operations operations = new Operations();
    private Border lightGray;
    private Color color;

    private JLabel textWelcome;
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private FlowLayout layout;
    //private JComboBox comboBox;
    private JLabel myWelcomeTex = new JLabel("Welcome to Palmer Group Portal");
    private FlowLayout setLayout;
    private JButton loginButton = new JButton("Login");
    private JCheckBox checkButton = new JCheckBox();
    private JLabel showPassword = new JLabel("Show password");


    LoginPage () {
        super("Payroll Portal");
        setLayoutMan();
        setMyLayout();
        allContainer();

        theHandler handler = new theHandler();
        usernameField.addActionListener(handler);
        passwordField.addActionListener(handler);
        checkButton.addActionListener(handler);

    }
    public void setLayoutMan (){
        container.setLayout(null);
    }
    public void setMyLayout () {
        //myWelcomeTex.setBounds(300, 5, 100, 20);
        lightGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, true);


         usernameLabel.setBounds(50, 120, 100, 30);
         usernameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
         passwordLabel.setBounds(50, 180, 100, 30);
         passwordLabel.setFont(new Font("Serif", Font.PLAIN, 20));
         usernameField.setBounds(150, 120, 150, 30);
         usernameField.setBorder(BorderFactory.createRaisedBevelBorder());
         usernameField.setBorder(lightGray);
         passwordField.setBounds(150, 180, 150, 30);
         passwordField.setBorder(BorderFactory.createRaisedBevelBorder());
         passwordField.setBorder(lightGray);
         myWelcomeTex.setBounds(30, 20, 800, 50);
         myWelcomeTex.setFont(new Font("Dialog_input", Font.PLAIN, 35));
         loginButton.setBounds(250, 265, 80, 40);
         checkButton.setBounds(60, 230, 30, 30);
         showPassword.setBounds(90, 230, 150, 30);
    }
    public void allContainer() {
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(myWelcomeTex);
        container.add(loginButton);
        container.add(checkButton);
        container.add(showPassword);
    }

//This class handles the actions that happens to the username and password field
    private class theHandler implements ActionListener {
        boolean checkString;
        public void actionPerformed(ActionEvent event) {
        if (event.getSource() == usernameField){
            userName = usernameField.getText().toLowerCase();
            checkString = operations.usernameCheck(userName);
            if(checkString == true) {
                JOptionPane.showMessageDialog(null,"The value of username is " + userName);
            }
            else {
                JOptionPane.showMessageDialog(null,"Please enter a valid username \n" +
                        "Valid username only includes letters and/or numbers and no space");
            }

        }

            if (event.getSource() == passwordField){
                boolean checkPassword;
                //passwordField.setEchoChar('\u26AB');
                password = passwordField.getText();
                checkPassword = operations.passwordValidCheck(password);
                if(checkPassword == true){
                    JOptionPane.showMessageDialog(null,"The value of password is " + password);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please enter a valid password. \n "
                            + "A valid password does not include a space ");
                }

            }


                if(checkButton.isSelected()){
                    passwordField.setEchoChar((char)0);
                } else
                {
                    passwordField.setEchoChar('\u26AB');
                }


        }
    }

    public String getPassword() {
        return password;
    }
}
