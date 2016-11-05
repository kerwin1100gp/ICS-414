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
				 
				 static Scanner input = new Scanner(System.in);

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

			         initComponents();
			     }

			     @Override
			     public void actionPerformed(ActionEvent e){
			         if(e.getSource().equals(timer))
			             clockLabel.setText(sdf.format(
			                 new Date(System.currentTimeMillis())));
			     }

			     private void initComponents() {

			         GroupLayout layout = new GroupLayout(this);
			         ParallelGroup parallelGroupH = layout.createParallelGroup(
			                 GroupLayout.Alignment.LEADING);
			         this.setLayout(layout);
			         layout.setHorizontalGroup(
			                 parallelGroupH
			                 .addGap(0, 400, Short.MAX_VALUE)
			                 );
			         ParallelGroup parallelGroupV = layout.createParallelGroup(
			                 GroupLayout.Alignment.LEADING);
			         layout.setVerticalGroup(
			                 parallelGroupV
			                 .addGap(0, 30, Short.MAX_VALUE)
			                 );
			         parallelGroupH.addComponent(clockLabel);
			         parallelGroupV.addComponent(clockLabel);
			     }

			     public static void main(String[] args) throws Exception {
			    	 System.out.println("Welcome to Team Orange's ICS 414 Digital Timer Project. Please select an option to begin \n 1) Begin Timer \n 2) See User Instructions \n 3) Exit Program");
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
			    		 System.out.println("Instructions...");
			    		 
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
