package Controller;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import IHM.IHM;
import fr.istic.m2miage.Command;

public class Controlleur extends JFrame {

	public Controlleur(){
		
	}
	
	
	private Command command;

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public static void main(String [] args){
	      JFrame frame = new IHM();
	      
	   }
	
}

