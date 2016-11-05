/**
 *The object class for the DigitalTimerObject.java. 
 * 
 * @author Kevin Beydler, Bryson, Kerwin 
 * @version ICS 414
 * @date 11/2/2016
 **/

//import preprocessor directives
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	public class DigitalTimerObject extends JLabel implements ActionListener{
	  private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); // sets the format for the Digital Timer obj
	  private Timer timer;
	  
	  
	  /*
	   * Method: To create a basic timer JLabel digitaltimer object that counts incrementally (need to descend for project)
	   */
	  public DigitalTimerObject(){
	     
		  super();

		  //All of the specs for the digital timer itself (i.e., its text format, the colors of the background/foreground, the speed it counts at)
	     setText(sdf.format(new Date(System.currentTimeMillis())));
	     setFont(new Font("Monospaced", Font.BOLD, 100));
	     setOpaque(true);
	     setBackground(Color.white);
	     setForeground(Color.black);

	     setVisible(true);
	  }
	  /*
	   * Action listener object to confirm that the action of the digital timer occurred... help was from oracle javadoc
	   */
	  public void actionPerformed(ActionEvent e){
	     if(e.getSource().equals(timer))
	        setText(sdf.format(new Date(System.currentTimeMillis())));
	  }
	 }
