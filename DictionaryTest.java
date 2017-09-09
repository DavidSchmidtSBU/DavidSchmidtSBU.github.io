// The "DictionaryTest" class. 
// Located in: Examples\Ch09\DictLinkedList\DictionaryTest.java 
// This programs tests the Dictionary class by allowing the user to enter 
// commands to a dictionary object.
package hash;
import java.io.*;

public class DictionaryTest 
{ 
    protected static void giveInstructions () 
    //PRE: NA 
    //POS: NA 
    //TAS: Display the instructions for the program.

    { 
     System.out.println ("Command to program:"); 
     System.out.println ("   i  insert"); 
     System.out.println ("   d  delete"); 
     System.out.println ("   s  search"); 
     System.out.println ("   e  is empty"); 
     System.out.println ("   h  help"); 
     System.out.println ("   q  quit"); 
    }

    protected static void fill (Dictionary D, int inputs){ 
      for (int j = 0; j < inputs; j++) { 
        D.put (Integer.toString(j), "element"); 
      } 
      System.out.println ("collisions are: " + D.collisions()); 
    }

    // The main method. This throws an IOException because we do not 
    // handle any exceptions from reading the keyboard in the method. 
    public static void main (String args []) throws IOException 
    { 
     Dictionary dict; 
     BufferedReader in = new BufferedReader (new InputStreamReader (System.in)); 
     String command;  
     dict = new Dictionary (); //Empty dictionary 
     fill(dict,100);           //Fill it with 100 entries
     dict = new Dictionary (); 
     fill(dict, 500);          //Fill it with 500 entries
     dict = new Dictionary ();  
     fill(dict, 750);          //Fill it with 750 entries
     dict = new Dictionary (); 
     fill(dict, 1000);         //Fill it with 1000 entries
     dict = new Dictionary (); 
     fill(dict, 1250);         //Fill it with 1250 entries
     dict = new Dictionary (); 
     fill(dict, 1500);         //Fill it with 1500 entries
     dict = new Dictionary (); 
     fill(dict, 2000);         //Fill it with 2000 entries
     dict = new Dictionary (); 
     fill(dict, 2250);         //Fill it with 2250 entries
     dict = new Dictionary (); 
     fill(dict, 2500);         //Fill it with 2500 entries
     giveInstructions ();

     while (true) 
     { 
       System.out.print ("Command: ");

       command = in.readLine (); 
       if (command.equals ("i")) 
       { 
        String key, element;

        System.out.print ("Enter key: "); 
        key = in.readLine ();

        System.out.print ("Enter element: "); 
        element = in.readLine (); 
        dict.put (key, element); 
       } 
       else if (command.equals ("d")) 
       { 
        String key;

        System.out.print ("Delete key: "); 
        key = in.readLine ();

          dict.remove (key); 
       } 
       else if (command.equals ("s")) 
       { 
        String key, element;

        System.out.print ("Search for key: "); 
        key = in.readLine ();

        // The dictionary stores only Objects. We must cast the Object 
        // back to a String. 
        element = (String) dict.get (key); 
        if (element == null) 
        { 
          System.out.println (key + " not found."); 
        } 
        else 
        { 
          System.out.println ("Element: " + element); 
        } 
       } 
       else if (command.equals ("e")) 
       { 
         System.out.println ("Is Empty: " + dict.isEmpty ()); 
       } 
       else if (command.equals ("h")) 
       { 
         giveInstructions (); 
       } 
       else if (command.equals ("q")) 
       { 
         System.out.println ("Quitting"); 
         break; 
       } 
        else 
       { 
         System.out.println ("Sorry, bad command: " + command); 
       } 
     } // while 
    } // main method 
} /* DictionaryTest class */ 
  