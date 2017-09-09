package practiceMethods;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PracticeMethods
{
	public static void main( String[] args )
	{
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Enter your first name");
	 String myName = scan.nextLine();
	 System.out.println("hello "+ myName);
	 System.out.println("how many letters are in the name");
     System.out.println(myName.length());
     
     System.out.println("Year of birth");
     int myYear = scan.nextInt();
     int age = (2016 - myYear);
     System.out.println(age);
     final double LIFE_EXPECTANCY = 78.7;
     double percentage_of_life = (19 / LIFE_EXPECTANCY);
     DecimalFormat myDec = new DecimalFormat("##%");
     System.out.println(myDec.format(percentage_of_life));
     
     
     Random random = new Random();
     int start = 1, end = 20;
     int number = random.nextInt( end - start + 1 ) + start;
     String input = JOptionPane.showInputDialog( null,"Please enter your number" );
     int number1 = Integer.parseInt(input);
     JOptionPane.showMessageDialog(null, "The number was "+number+". You were  "+Math.abs(number1 - number) + " away.");
     //System.out.println("\nThe random number between " + start + " and " + end + " is " + number );
     
     
     
     
     
     
    
    		 
	
	}
	
}

