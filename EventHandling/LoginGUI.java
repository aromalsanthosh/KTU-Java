/*
 * @name        A Login GUI
 * @package     GUIProjects
 * @file        LoginGUI.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
package guiprojects;
import java.awt.TextField;
import java.awt.*;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class LoginGUI extends Frame {
	// declare variables
	private Label label1,label2;
	private TextField txtF1;
	private TextField passF;
	private Button buttonExit,buttonLogin;
	private Panel panelLogin;

	// Looking for a better way to store this.
	private final String uid = "Yedhin";
	private final String pass = "*123#";

	// Constructor for the class
	public LoginGUI(){
		// set title
		super("EventHandling basics");
		txtF1 = new TextField();
		passF = new TextField();
		label1 = new Label();
		label2 = new Label();
		panelLogin = new Panel();
		buttonExit = new Button("close");
		buttonLogin = new Button("login");

		// explictely setting layout. default is Flow itself
		setLayout(new FlowLayout());


		// create a label for username
		label1.setAlignment(Label.CENTER);
		label1.setText("Username");
		add(label1); // add the label to the Frame

		// set initial width of the the TextFields
		txtF1.setColumns(20);
		passF.setColumns(20);

		// changing echoing of characters typed in password field into *
		passF.setEchoChar('*');

		add(txtF1);

		// create a label for password
		label2.setAlignment(Label.CENTER);
		label2.setText("Password");
		add(label2);

		add(passF);

		// create an exit button
		add(buttonExit);

		// login button
		panelLogin.add(buttonLogin);
		add(panelLogin);

		// create an listener object.
		theHandler handler = new theHandler();

		// add action listeners for both the buttons
		buttonExit.addActionListener(handler);
		buttonLogin.addActionListener(handler);
	}

	// EventHandling class
	private class theHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Event on close button
			if( e.getSource() == buttonExit ) {
				dispose();
				System.exit(0);
			}

			// Event on login button
			if(e.getSource() == buttonLogin){
				if(txtF1.getText().equals(uid) && passF.getText().equals(pass)){
					JOptionPane.showMessageDialog(null,"Successfull Login");
					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException ex){
						System.out.println("Exception "+ex+" Caught");
					}
					dispose();
					System.exit(0);
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
				}
			}
		}
	}

	// main starts here
	public static void main(String[] args) {
		LoginGUI frameObj = new LoginGUI();
		frameObj.setSize(600,600);
		frameObj.setVisible(true);
	}
}
