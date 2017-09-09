package patternmatching;

import java.io.*;

import javax.swing.JOptionPane;
public class Processor
{
    private String fileName;
    private String searchText = "";
    private char [] textArray;

    public Processor (String fileName)
    //PRE: init<fileName>
    //POS: this.filename == fileName
    //TAS: instantiate a processor object
    {
        this.fileName = fileName;
        
        //System.out.println(this.fileName);
    }//Processor

    public int bruteForce (String pattern)
    //PRE: init <pattern> && init <searchText>
    //POS: none
    //TAS: return location in file where target is located OR
    //     -1 if not found
    {

        int pLoc;  //pattern location
        int count = 0;
        /////// - Loop through text looking for pattern - ///////
        for (int sLoc = 0; sLoc < (searchText.length()-(pattern.length()-1)); sLoc++)
        {
            pLoc = 0;  //pattern location starts at 0 each time
            //showProgress (pattern, sLoc, false);
            /////// - While there are more characters to compare and all have been matches - ///////
            while ((pLoc < pattern.length()) && (searchText.charAt(sLoc+pLoc)==pattern.charAt(pLoc)))
                pLoc++;
                count++;
            ////// - We reached the end of the pattern so all characters match
            if (pLoc == pattern.length())
            	return (sLoc);
            System.out.println(count);
        }//for

        /////// - Didn't find it - ////////
        return -1; //stubbed code
    }//bruteForce

    private void initializeSkipArray (int [] skip, String pattern)
    {
        /////// - Fill skipArray with majority skip--length of pattern - ///////
        for (int i = 0; i < skip.length; i++)
          skip[i] = pattern.length();
        ////// - Adjust the skipArray for the letters in the pattern - //////
        for (int j = 0; j < pattern.length(); j++)
            skip [pattern.charAt(j)-65] = pattern.length()-(j+1);

        ////// - Print out the skipArray - //////
        for (int k = 0; k < skip.length; k++)
            System.out.print (skip[k]);
        System.out.println();
    }

    public int boyerMoore (String pattern)
    //PRE: init <search>
    //POS: none
    //TAS: return location in file where target is located OR
    //     -1 if not found
    {
        /////// - Create the skip array - ///////
        int [] skipArray = new int [26];
        initializeSkipArray(skipArray, pattern);

        // Start both counters at location of pattern's rightmost character
        // For "DXY", the position would be 2 in both pattern and text
        int currentChar;
        int pLoc = pattern.length()-1;    //The rightmost character in your pattern
        int tLoc = pattern.length()-1;    //The location in your text searching begins
        int count = 0;
        
        while(tLoc < searchText.length()) //As long as there is text to search
        {
            pLoc = pattern.length()-1;	  //Set (or reset) to the rightmost character in the pattern
                      
            if (searchText.charAt(tLoc)!= pattern.charAt(pLoc))//no match, skip ahead by the skip value in array
            {
                tLoc = tLoc + skipArray[searchText.charAt(tLoc)-65];
                count++;
            }//if
            else //must match
            {
                currentChar = tLoc;          
                while ((pLoc >= 0) && (searchText.charAt(currentChar)== pattern.charAt(pLoc)))
                {//Do a backwards bruteforce                 
                    currentChar--;
                    pLoc--;
                    count++;
                    if (searchText.charAt(currentChar)!= pattern.charAt(pLoc))//no match
                        tLoc = tLoc + skipArray[searchText.charAt(currentChar)-65];
                    else if (pLoc <= 0)
                    {
                    	System.out.println(count);
                        return (tLoc-(pattern.length()-1));
                    }
                }//while
            }//else
        }//while
        return -1;
        
    } //boyerMoore

    public void load ()
    //PRE: init<fileName>
    //POS: searchText[0..Text.length] contains uppercase letters A..Z
    //TAS: read fileName and place into an array of char
    {
        BufferedReader in;
        String lineOfText;
        try
        {
            in = new BufferedReader (new FileReader (fileName));
        }
        catch (FileNotFoundException e)
        {
        	JOptionPane.showMessageDialog(null, "File not found. ");
            System.out.println (fileName + " not found.");
            return;
        }
        try
        {
            lineOfText = in.readLine ();
            while (lineOfText != null)
            {
              searchText = searchText+lineOfText;// Add code to place the lineOfText characters into an array
              lineOfText = in.readLine ();
            }
        }
        catch (IOException e)
        {
            System.out.println ("An I/O error occurred reading " + fileName);
        }
        try
        {
            in.close ();
        }
        catch (IOException e)
        {
            System.out.println ("An I/O error occurred closing " + fileName);
        }
        //Put the string into an array
        textArray = new char [searchText.length()];
        for (int i = 0; i < searchText.length(); i++)
            textArray[i] = searchText.charAt(i);

    } // load method 
}//END class Processor