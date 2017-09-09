package programmingassignment4;

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class Picture
{
	public static void main(String []args) throws FileNotFoundException
	{
		//input which picture you want
	    String filename = JOptionPane.showInputDialog(null, "What is the picture's file name? Please have .ppm in input."); 
		//gray picture
		PPMPicture mypicture = new PPMPicture(filename);
		mypicture.setToGrayScale();
	    mypicture.save("Picture2.ppm");
		//negative picture
		mypicture.setToNegative();
	    mypicture.save("Picture3.ppm");
		//artwork
		mypicture.setArtwork();
	    mypicture.save("Picture4.ppm");
	}//main 
}//class