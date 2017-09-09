package patternmatching;

import javax.swing.JOptionPane;
import java.util.*;

public class Test {
	
    public static void main (String [] args)
    { 
    	System.out.print("Enter a filename: ");
    	Scanner scan = new Scanner(System.in);
    	String filename = scan.next();
    	System.out.print("Enter a String: ");
    	Scanner scan1 = new Scanner(System.in);
    	String pattern = scan.next();
        Processor p = new Processor (filename);
        String target = (pattern);
        p.load();
        int location = p.boyerMoore(target);
        if (location == -1)
            System.out.println("Text not found.");
        else
            System.out.println("Text found at location: "+location);
    }// END main
    
}// END Test