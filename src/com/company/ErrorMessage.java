package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

//This class display a message to the applicant if he leaves a case empty or did not enter the right thing
public class ErrorMessage {
    private Stack<String> holdError = new Stack<String>();
    private JFrame frame = new JFrame("Error Message");
    private JLabel text = new JLabel();
    public void setMessage(String x){
        holdError.add(x);

    }
    public void getMessage(){
//        frame.setLayout(null);
//             for (int i=0; i < holdError.size(); i++){
//                 frame.add(text);
//                // text.setText();
//             }
//
//             frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//             frame.setSize(200, 200);
//             frame.setVisible(true);
            JOptionPane.showMessageDialog(null, String.format(holdError.toString(), 10, 10));
    }

    public void clearStack(){
        holdError.clear();
    }


}
