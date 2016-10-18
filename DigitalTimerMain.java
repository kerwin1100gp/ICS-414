/**
 *The main driver class for the DigitalTimerMain.java. 
 * 
 * @author Kevin Beydler, Bryson, Kerwin 
 * @version ICS 414
 * @date 10/19/2016
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

public class DigitalTimerMain {
	
	int seconds = 0;
	
	Timer timer = new Timer(); //creating a standard java.util timer obj
	
	TimerTask task = new TimerTask(){
		public void run(){
		seconds++;
		System.out.println(seconds);
		}
	};
	//start method to start the timer when called in main()
	public void start(){
		timer.scheduleAtFixedRate(task,1000,1000);
	}

	//main driver function
	public static void main(String[] args) {
		
				System.out.println("Beginning Your Work Session:");
				DigitalTimerMain digitaltimer = new DigitalTimerMain();
				digitaltimer.start();
	}
	
	
	//need to create the parameters of the Digital Timer
	//need an actual working timer

}
