/**
 *The main driver class for the DigitalTimerMain.java. 
 * 
 * @author Kevin Beydler, Bryson, Kerwin 
 * @version ICS 414
 * @date 11/2/2016
 **/

	//import preprocessor directives
	 import java.awt.Color;
	 import java.awt.Font;
	 import java.awt.event.ActionEvent;
	 import java.awt.event.ActionListener;
	 import java.text.SimpleDateFormat;
	 import java.util.Date;
	 import javax.swing.Timer;
	 import java.util.Scanner;
	 import java.awt.*;
	 import java.awt.event.ActionEvent;
	 import java.awt.event.ActionListener;
	 import java.text.SimpleDateFormat;
	 import java.util.Date;
	 import javax.swing.*;
	 import javax.swing.GroupLayout.ParallelGroup;

			 /*
			  * main class: uses JPanel object for GUI
			  */
			 public class DigitalTimerMain extends JPanel implements ActionListener {
				 
				 static Scanner input = new Scanner(System.in); //for user interaction within the console

				 //instantiates variables for digital timer
			     private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			     private Timer timer;
			     private JLabel clockLabel = new JLabel("Time");
					
			     public DigitalTimerMain() {
			         super();

			         clockLabel.setText(sdf.format(new Date(System.currentTimeMillis())));
			         clockLabel.setFont(new Font("Monospaced", Font.BOLD, 100));
			         clockLabel.setOpaque(true);
			         clockLabel.setBackground(Color.white);
			         clockLabel.setForeground(Color.black);

			         timer = new Timer(500, this);
			         timer.setRepeats(true);
			         timer.start();

			         createComponents(); //calls the create components method to create the display box
			     }

			     @Override
			     public void actionPerformed(ActionEvent e){
			         if(e.getSource().equals(timer))
			             clockLabel.setText(sdf.format(
			                 new Date(System.currentTimeMillis())));
			     }
				
				 /*
				 * Method: Creates the components for the Digital Timer GUI box
				 * Reference: https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
				 */
			     private void createComponents() {

			         GroupLayout layout = new GroupLayout(this);
			         ParallelGroup parallelGroupH = layout.createParallelGroup(
			                 GroupLayout.Alignment.LEADING);
			         this.setLayout(layout);
			         layout.setHorizontalGroup(
			                 parallelGroupH
			                 .addGap(0, 400, Short.MAX_VALUE)
			                 ); //sets the horizontal side of the GUI box
			         ParallelGroup parallelGroupV = layout.createParallelGroup(
			                 GroupLayout.Alignment.LEADING);
			         layout.setVerticalGroup(
			                 parallelGroupV
			                 .addGap(0, 30, Short.MAX_VALUE)
			                 ); //sets the vertical side of the GUI box
			         parallelGroupH.addComponent(clockLabel);
			         parallelGroupV.addComponent(clockLabel);
			     }
	
				 
				 /*
				 * Method: main() needs to provide UI for options to user (GUI JOptionPane) - Prototype can be in the console
				 */
			     public static void main(String[] args) throws Exception {
			    	 	//Console with UI
				     System.out.println("Welcome to Team Orange's ICS 414 Digital Timer Project. Please select an option to begin \n 1) Begin Timer \n 2) See User Instructions \n 3) Exit Program");
			    	
				     //displays options with a do-while loop -  user can select by entering 1-3 - scanner obj
				    // NEED TO MAKE BETTER USER INTERACTION MENU
				     do
			    	 {
			    	 if(input.nextInt() == 1){
			         SwingUtilities.invokeLater(new Runnable() {
			             public void run() {
			                 JOptionPane.showMessageDialog(null, new DigitalTimerObject());
			             }
			         });
			    	 }
			    	 else if(input.nextInt() == 2)
			    	 {
			    		 System.out.println("Instructions: This is a Digital Timer. This is an independent application with a JOptionPane GUI for the user. \n This helps software developers by giving them a timer of work that they need to do before they take a break.");
			    		 
			    	 }
			    	 else if(input.nextInt() == 3)
			    	 {
			    		 System.out.println("Exiting...");
			    		 System.exit(0);
			    	 }
			    	 else if(input.nextInt() != 1 ||input.nextInt() != 2 ||input.nextInt() != 3)
			    	 {
			    		 System.out.println("ERROR: Please enter one of the possible options.");
			    	 }
			    	 }while(input.nextInt() != 1 ||input.nextInt() != 2 ||input.nextInt() != 3);
			     }
			 }
