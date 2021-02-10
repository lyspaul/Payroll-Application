package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	//LoginPage loginPage = new LoginPage();
	LoginPage newPage = new LoginPage();
	newPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	newPage.setSize(600, 400);
	newPage.setVisible(true);
	Operations ope = new Operations();
	//System.out.println("my method " + ope.methodShow());
    }
}
