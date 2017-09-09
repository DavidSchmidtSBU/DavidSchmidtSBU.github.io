package objectArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//CIS1144, Lab 13 
//Name: David Schmidt 
//Date: 11-15-16
//Filename: ObjectArrays.java 
//This program will experiment with arrays of objects
public class ObjectArrays 
{ 
    public static void main (String [] args) 
    { 
     // Insert your code below this line
     LineScore [ ] lineScores = new LineScore[12];
     try 
     {
    	 File file = new File ("scores.txt");
    	 Scanner scan = new Scanner( file );
		while(scan.hasNext())
		{
		  for (int i = 0; i < lineScores.length; i++)
		  {
			  lineScores[i] = new LineScore();
			  lineScores[i].setTeam(scan.next());
			  lineScores[i].setRuns(scan.nextInt());
			  lineScores[i].setHits(scan.nextInt());
			  lineScores[i].setErrors(scan.nextInt());
		  }//for
		}//while
	   for (int j = 0; j < lineScores.length; j++)
	   {
		   System.out.println("Team\t\tR H E");
		   System.out.println(lineScores[j].getTeam() + "\t\t" 
				   + lineScores[j].getRuns() + " " + lineScores[j].getHits() + " " + lineScores[j].getErrors() );
	   }
	 }//try 
     catch (FileNotFoundException e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }//catch
    }//END main 
}//END Arrays
