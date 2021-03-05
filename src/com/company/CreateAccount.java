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
    final private JTextField employeeIDField = new FocusListenerHandler("Employee Number");
    final private JTextField firstNameField = new FocusListenerHandler("First name");
    final private JTextField lastNameField = new FocusListenerHandler("Last name");
    final private JTextField usernameField = new FocusListenerHandler("Username");
    final private JPasswordField passwordField = new JPasswordField("Password");
    final private JPasswordField confirmPasswordField = new JPasswordField("Password");
    final private JTextField emailAddressField = new FocusListenerHandler("Email Address");
    final private JTextField addressField = new FocusListenerHandler("Address");
    final private JTextField cityField = new FocusListenerHandler("City");
    final private JTextField zipcodeField = new FocusListenerHandler("Zip code");
    final private JLabel createAccountLabel = new JLabel("CREATE AN ACCOUNT");
    final private JComboBox stateList = new  JComboBox(getStatesList());
    final private Font font = new Font("Arial", Font.BOLD, 20);
    private String state;
    final private JLabel backgroundImage;
    final private ImageIcon wallPaper = new ImageIcon("wallpaper.jpg");
    final private JLabel jFrameBackgroundLabel;
    private BufferedImage image = null;
    final private JLabel test;
    private BufferedImage logo = null;
    final private JLabel companyLogoLabel;
    final private JLabel test2;
    final private JButton createAccountButton = new JButton("CREATE ACCOUNT");
    final private MaskFormatter formatter = new MaskFormatter("(###) ###-####");
    private JFormattedTextField phoneNumberField1 = new JFormattedTextField(formatter);
    final private ArrayList<Boolean> isCreateButtonValid = new ArrayList<Boolean>();
    final private ErrorMessage error = new ErrorMessage();

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
                jFrameBackgroundLabel.getHeight(), Image.SCALE_SMOOTH); //Adjust the image size to the JLabel' size
        ImageIcon jFrameBackgroundImg = new ImageIcon(dimensionImage);
        test = new JLabel("", jFrameBackgroundImg, JLabel.LEFT);
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
//               System.out.println("HAHAAH");
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

    //*** Method to store all the client info ***

        private void storeValues(){
            try {
            StoreData data = new StoreData(firstNameField.getText(), lastNameField.getText(), emailAddressField.getText(),
                    employeeIDField.getText(), usernameField.getText(), passwordField.getPassword().toString(),
                    addressField.getText(), cityField.getText(), state, zipcodeField.getText(), phoneNumberField1.getText());
            data.storeDataMySQL();
                System.out.println("value stored");
        } catch (Exception e){
                e.printStackTrace();
            }
    }


    class CreateButtonHandler implements ActionListener { //Create Button Action Listener

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            Name name = new Name(firstNameField.getText(), lastNameField.getText());
            if(name.CheckFirstName() == false) {
                error.setMessage("Please enter a valid first name");
                isCreateButtonValid.add(false);
            } else if (name.CheckFirstName() == true){
                isCreateButtonValid.add(true);
            }
            if (name.CheckLastName() == false){
                error.setMessage("Please enter a valid last name");
            } else if (name.CheckLastName() == true){
                isCreateButtonValid.add(true);
            }

        } catch (Exception e){
            //error.setMessage("Please enter first name");
            //isCreateButtonValid.add(false);
        }

//        if (lastNameField.getText().isEmpty()) {
//            System.out.println("Last name is empty");
//            isCreateButtonValid.add(false);
//        }



    try {
        Email email = new Email(emailAddressField.getText());
        //email.checkEmail();
        if(email.checkEmail() == false) {
            error.setMessage("Please enter a valid email address");
            isCreateButtonValid.add(false);
            System.out.println("INValid email");
        } else {
            isCreateButtonValid.add(true);
        }
    } catch (Exception e){

    }
    try{
        EmployeeID employeeID = new EmployeeID(employeeIDField.getText());
        if(employeeID.checkValidation() == false){
            error.setMessage("Non valid Employee ID");
            isCreateButtonValid.add(false);
        } else
            isCreateButtonValid.add(true);
    }
    catch(Exception e) {

    }
    try{
        Username username = new Username(usernameField.getText());
        if(username.checkValidation() == false){
            error.setMessage("Invalid username");
        } else
            username.checkValidation();
    }
    catch (Exception e){

    }
    try {
        if (usernameField.getText().isEmpty()) {
//            System.out.println("Username is empty");
            isCreateButtonValid.add(false);
        }
        if (passwordField.getText().isEmpty()) {
//            System.out.println("Password is empty");
            isCreateButtonValid.add(false);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        if (confirmPasswordField.getText().isEmpty()) {
//            System.out.println("Please Enter a Password");
            isCreateButtonValid.add(false);
        }
        if (addressField.getText().isEmpty()) {
//            System.out.println("Please Enter an address");
            isCreateButtonValid.add(false);
        }
        if (cityField.getText().isEmpty()) {
            System.out.println("Please Enter a city");
            isCreateButtonValid.add(false);
        }
        if (zipcodeField.getText().isEmpty()) {
//            System.out.println("Please Enter a zipcode");
            isCreateButtonValid.add(false);
        }

            ZipCode zipCode = new ZipCode(zipcodeField.getText());
            if(zipCode.checkZipcode() == false) {
//                System.out.println("Please Enter a valid zipcode");
                isCreateButtonValid.add(false);
            }
        try {
            if (state.trim().toLowerCase().equals("state")) {
                error.setMessage("PLease enter state");
                error.getMessage();
                //System.out.println();
                isCreateButtonValid.add(false);
            }
        } catch (Exception e){
            System.out.println("Error");
        }
//            try {
//                if (state.equals(null)) {
//                    System.out.println("Please enter a state empty");
//                    isCreateButtonValid.add(false);
//                }
//            } catch (Exception e) {
//                System.out.println("Yes");
//            }

        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberField1.getText());
        if (phoneNumberField1.getText().isEmpty()) {
//            System.out.println("Phone number is empty");
            isCreateButtonValid.add(false);
        }


        //checks if all conditions are met to create an account
        if (isCreateButtonValid.contains(false)) {
            for(int i=0; i<isCreateButtonValid.size(); i++){

                //System.out.println("FALSE VALUE of  " + i + " is " + isCreateButtonValid.get(i));
                //isCreateButtonValid.clear();
            }
//
//            System.out.println("SORRY CANNOT PERFORM CREATE ACCOUNT");
            error.getMessage();
            error.clearStack();


        } else
        {
            JOptionPane.showMessageDialog(null, "SUCCESSFUL CREATE ACCOUNT");
            storeValues();
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
//                System.out.println("focus lost");
            }
        }

    public void focusGained(FocusEvent e){
        if(this.getText().isEmpty()){
            super.setText("");
            showingHint = false;
//            System.out.println("focus gained");
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
