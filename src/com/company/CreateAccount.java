package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.ArrayList;

public class CreateAccount extends States  implements PageStructure  { //Beginning of class
    final private JPanel panel = new JPanel();
    final private JPanel panel2 = new JPanel();
    final private JFrame frame = new JFrame("Register account");
    private JPanel container = new JPanel();
    private String employeeID;
    private JTextField employeeIDField = new FocusListenerHandler("Employee Number");
    private String firstName;
    private JTextField firstNameField = new FocusListenerHandler("First name");
    private String lastName;
    private JTextField lastNameField = new FocusListenerHandler("Last name");
    private String month;
    private String day;
    private String year;
    private String username;
    private JTextField usernameField = new FocusListenerHandler("Username");
    private String password;
    private JPasswordField passwordField = new JPasswordField("Password");
    private JPasswordField confirmPasswordField = new JPasswordField("Password");
    private String emailAddress;
    private String confirmPassword;
    private JTextField emailAddressField = new FocusListenerHandler("Email Address");
    private String address;
    private JTextField addressField = new FocusListenerHandler("Address");
    private String city;
    final private JTextField cityField = new FocusListenerHandler("City");
    private String zipcode;
    private JTextField zipcodeField = new FocusListenerHandler("Zip code");
    //private JTextField phoneNumberField1 = new FocusListenerHandler("Phone number");
    private String phoneNumber;
    private JLabel createAccountLabel = new JLabel("CREATE AN ACCOUNT");
    private JComboBox stateList = new  JComboBox(getStatesList());
    private Font font = new Font("Arial", Font.BOLD, 20);
    private String state;
    private JLabel backgroundImage;
    private ImageIcon wallPaper = new ImageIcon("wallpaper.jpg");
    private JLabel jFrameBackgroundLabel;
    private BufferedImage image = null;
    private JLabel test;
    private BufferedImage logo = null;
    private JLabel companyLogoLabel;
    private JLabel test2;
    private JButton createAccountButton = new JButton("CREATE ACCOUNT");
    private MaskFormatter formatter = new MaskFormatter("(###) ###-####");
    //private MaskFormatter secondFormatter = new MaskFormatter("#####-####");
    private JFormattedTextField phoneNumberField1 = new JFormattedTextField(formatter);
    private ArrayList<Boolean> isCreateButtonValid = new ArrayList<Boolean>();

    public CreateAccount() throws ParseException { //Beginning of Constructor

        allContainer();
        jFrameBackgroundLabel = new JLabel();
        companyLogoLabel = new JLabel();
        //zipcodeField.setColumns(10);
        // *** Start coding about the JFrame background
        try {
            jFrameBackgroundLabel.setBounds(0, 0, 485, 535);
            companyLogoLabel.setBounds(5, 5, 50, 50);
        } catch (Exception e) {
            System.out.println("Exception happened" + e);
        }
        try{
            image = ImageIO.read(new File("background1.jfif"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        Image dimensionImage = image.getScaledInstance(jFrameBackgroundLabel.getWidth(),
                jFrameBackgroundLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon jFrameBackgroundImg = new ImageIcon(dimensionImage);
        test = new JLabel("", jFrameBackgroundImg, JLabel.LEFT);;
        test.setBounds(0, 0,485, 535);
        test.setBorder(lightGray);

        //End coding about JFrame background ***

        //*** Start coding about Eagle Logo on JFrame
        try {
           logo = ImageIO.read(new File("Eagle_logo.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Image logo_Dimension = logo.getScaledInstance(companyLogoLabel.getWidth(), companyLogoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(logo_Dimension);
        test2 = new JLabel("", logoImage, JLabel.LEFT);
        test2.setBounds(10, 10, 50, 50);

        //End coding about Eagle Logo on JFrame ***

        // *** Start coding about "Create Account" JLabel
        createAccountLabel.setBounds(130, 10, 250, 50);
        createAccountLabel.setFont(font);
        createAccountLabel.setForeground(Color.WHITE);

        //End coding about "Create Account" JLabel ***

        backgroundImage = new JLabel("", wallPaper, JLabel.CENTER);
        backgroundImage.setBounds(0, 0, 400, 370);
        backgroundImage.setBorder(lightGray);
        panel.add(backgroundImage);

        //Adding an item listener to ComboBox stateList
        stateList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED){
                    //stateList.setBackground(Color.WHITE);
                    System.out.println(event.getItem());
                    state = event.getItem().toString();
                }
            }
        }); //end of stateList.addItemListener

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(passwordField.getText().trim().toLowerCase().equals("password")){
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().trim().toLowerCase().equals("password") || passwordField.getText().trim().toLowerCase().equals("") ){
                    passwordField.setText("Password");
                }
            }
        });
        confirmPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(confirmPasswordField.getText().trim().toLowerCase().equals("password")){
                    confirmPasswordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(confirmPasswordField.getText().trim().toLowerCase().equals("password") || confirmPasswordField.getText().trim().toLowerCase().equals("") ){
                    confirmPasswordField.setText("Password");
                }
            }
        });
        CreateButtonHandler buttonHandler = new CreateButtonHandler();
        createAccountButton.addActionListener(buttonHandler);
       phoneNumberField1.addFocusListener(new FocusListener()  {
           @Override
           public void focusGained(FocusEvent e) {
                if (phoneNumberField1.getText().equals("Phone number")) {
                    phoneNumberField1 = new JFormattedTextField(formatter);
                    phoneNumberField1.setText("");

                }
               System.out.println("HAHAAH");
           }

           @Override
           public void focusLost(FocusEvent e) {
               if (phoneNumberField1.getText().isEmpty()) {
                   phoneNumberField1 = new JFormattedTextField("Phone Number");
               }
               //System.out.println("OOGOGOOGGO");
           }
       });

    } //End of Constructor

    public void setLayoutMan (){
        panel.setLayout(null);
    }
    //Method to set my layout
    public void setMyLayout(){ //Beginning of setMyLayout()
        firstNameField.setBounds(25, 15, 150, 35);
        firstNameField.setBorder(border);
        firstNameField.setBorder(lightGray);
        lastNameField.setBounds(220, 15, 150, 35);
        lastNameField.setBorder(border);
        lastNameField.setBorder(lightGray);
        emailAddressField.setBounds(25, 65, 345, 35);
        emailAddressField.setBorder(border);
        emailAddressField.setBorder(lightGray);
        employeeIDField.setBounds(25, 115, 150, 35);
        employeeIDField.setBorder(border);
        employeeIDField.setBorder(lightGray);
        usernameField.setBounds(220, 115, 150, 35);
        usernameField.setBorder(border);
        usernameField.setBorder(lightGray);
        passwordField.setBounds(25, 165, 150, 35);
        passwordField.setBorder(border);
        passwordField.setBorder(lightGray);
        confirmPasswordField.setBounds(220, 165, 150, 35);
        confirmPasswordField.setBorder(border);
        confirmPasswordField.setBorder(lightGray);
        addressField.setBounds(25, 215, 345, 35);
        addressField.setBorder(border);
        addressField.setBorder(lightGray);
        cityField.setBounds(25, 265,  150, 35);
        cityField.setBorder(border);
        cityField.setBorder(lightGray);
        stateList.setBounds(220, 265,  150, 35);
        stateList.setBorder(border);
        stateList.setBorder(lightGray);
        stateList.setBackground(Color.WHITE);
        zipcodeField.setBounds(25, 315,  150, 35);
        zipcodeField.setBorder(border);
        zipcodeField.setBorder(lightGray);
        zipcodeField.setBackground(Color.WHITE);
        phoneNumberField1.setBounds(220, 315,  150, 35);
        phoneNumberField1.setBorder(border);
        phoneNumberField1.setBorder(lightGray);
        phoneNumberField1.setBackground(Color.WHITE);
        createAccountButton.setBounds(165, 475, 150, 40);


    } //End of setMyLayout()



    //method that contains all my containers
        public void allContainer(){ //Beginning of allContainer() method
            setLayoutMan();
            setMyLayout();
            panel.setBounds(40, 90, 400, 370 );
            panel.add(employeeIDField);
            panel.add(cityField);
            panel.add(zipcodeField);
            panel.add(addressField);
            panel.add(emailAddressField);
            panel.add(usernameField);
            panel.add(passwordField);
            panel.add(lastNameField);
            panel.add(firstNameField);
            panel.add(confirmPasswordField);
            panel.add(stateList);
            panel.add(phoneNumberField1);
            panel.add(zipcodeField);
            panel.setBorder(border);
           panel.setBorder(lightGray);


        } //End of allContainer() method

    class CreateButtonHandler implements ActionListener { //Create Button Action Listener

    @Override
    public void actionPerformed(ActionEvent event) {
        if (firstNameField.getText().isEmpty()) {
            System.out.println("First name is empty");
            isCreateButtonValid.add(false);
        }


            Name name = new Name(firstNameField.getText());
            if(name.checkName() == true) {
                System.out.println("Valid name");
                isCreateButtonValid.add(true);
            } else {
                System.out.println("Please enter a valid name");
                isCreateButtonValid.add(false);
            }


        if (lastNameField.getText().isEmpty()) {
            System.out.println("Last name is empty");
            isCreateButtonValid.add(false);
        }

            Name name2 = new Name(lastNameField.getText());
            if(name2.checkName() == true) {
                System.out.println("Valid name");
                isCreateButtonValid.add(true);
            } else {
                System.out.println("Please enter a valid name");
                isCreateButtonValid.add(false);
            }

        if (emailAddressField.getText().isEmpty()) {
            System.out.println("Email address is empty");
            isCreateButtonValid.add(false);
        }
        Email email = new Email(emailAddressField.getText());

            if(email.checkEmail() == true) {
                System.out.println("Valid email");
                isCreateButtonValid.add(true);
            } else {
                System.out.println("Please enter a valid email");
                isCreateButtonValid.add(false);
            }

        if (employeeIDField.getText().isEmpty()) {
            System.out.println("Employee ID is empty");
            isCreateButtonValid.add(false);
        }
        if (usernameField.getText().isEmpty()) {
            System.out.println("Username is empty");
            isCreateButtonValid.add(false);
        }
        if (passwordField.getText().isEmpty()) {
            System.out.println("Password is empty");
            isCreateButtonValid.add(false);
        }
        if (confirmPasswordField.getText().isEmpty()) {
            System.out.println("Please Enter a Password");
            isCreateButtonValid.add(false);
        }
        if (addressField.getText().isEmpty()) {
            System.out.println("Please Enter an address");
            isCreateButtonValid.add(false);
        }
        if (cityField.getText().isEmpty()) {
            System.out.println("Please Enter a city");
            isCreateButtonValid.add(false);
        }
        if (zipcodeField.getText().isEmpty()) {
            System.out.println("Please Enter a zipcode");
            isCreateButtonValid.add(false);
        }

            ZipCode zipCode = new ZipCode(zipcodeField.getText());
            if(zipCode.checkZipcode() == false) {
                System.out.println("Please Enter a valid zipcode");
                isCreateButtonValid.add(false);
            }

            if (state.trim().toLowerCase().equals("state")) {
                System.out.println("Please enter a state");
                isCreateButtonValid.add(false);
            }

        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberField1.getText());
        if (phoneNumberField1.getText().isEmpty()) {
            System.out.println("Phone number is empty");
            isCreateButtonValid.add(false);
        }

        //checks if all conditions are met to create an account
        if (isCreateButtonValid.contains(false)) {
            for(int i=0; i<isCreateButtonValid.size(); i++){

                System.out.println("FALSE VALUE of  " + i + " is " + isCreateButtonValid.get(i));
                isCreateButtonValid.clear();
            }
            System.out.println("MY SIZEEEEE + " + isCreateButtonValid.size());
            System.out.println("SORRY CANNOT PERFORM CREATE ACCOUNT");


        } else
        {
            JOptionPane.showMessageDialog(null, "SUCCESSFUL CREATE ACCOUNT");
        }


//        } else
//            System.out.println("Valid");
    }
}
    class FocusListenerHandler extends JTextField implements FocusListener {
    private String hint;
    private boolean showingHint;
    public FocusListenerHandler(String hint){
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }
        public void focusLost(FocusEvent e){
            if(this.getText().isEmpty()){
                super.setText(hint);
                showingHint = true;
                System.out.println("focus lost");
            }
        }

    public void focusGained(FocusEvent e){
        if(this.getText().isEmpty()){
            super.setText("");
            showingHint = false;
            System.out.println("focus gained");
        }
    }

    public String getText() {
        return showingHint ? "" : super.getText();
    }
}

//    private void containFocusListener() {
//        //FocusListenerHandler handler = new FocusListenerHandler(cityField.getText());
//        //cityField.addFocusListener(handler);
//        cityField = new FocusListenerHandler(cityField.getText());
//    }

    public void getFrame() { //Beginning of getFrame() method

        frame.setLayout(null);
        frame.add(createAccountLabel);
        frame.add(createAccountButton);
        frame.add(panel);
        frame.add(test2);
        frame.add(test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 570);
        frame.setVisible(true);

    } //End of getFrame() method



} //End of Class ***
