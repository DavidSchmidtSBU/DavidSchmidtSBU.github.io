package recursionTest;

import javax.swing.JOptionPane;

////////////////////////////////////////////////////////////////////
//  Lab 12: Recursion
//  Name: <David Schmidt>
//
////////////////////////////////////////////////////////////////////

public class RecursionTest 
{ 

  public static int power (int x, int y) 
  // PRE: x > 0
  // POS: none
  // TAS: Recursively compute x to the y power and return the result. 
  {
	 //Print statement
     System.out.println("x is: " + x + " y is: " + y);
     //Base Case
	 if (y == 0)
       return 1;
	 //Smaller Caller
     else
       return x * power (x, y - 1);
  } // method recursiveExp

  public static int Multiply (int x, int y)
  {
	 //Print Statement
	 System.out.println("x is: " + x + " y is: " + y);
	 //Base Case
	 if (y == 0)
	   return 0;
	 //Smaller Caller
	 else
	   return x + Multiply (x, y - 1);
  } // method Multiply
  
  public static boolean pal (String p, int left, int right)
  //TASK: Return true if p is a palindrome (reads the same forwards as backwards)
	{
        //BASE CASE #1 left >= right indicates the entire word has been checked
		if (left >= right)	
			return true;

		//BASE CASE #2 if the letters don’t match, then p is not a palindrome
		else if (p.charAt(left) != p.charAt(right))
			return false;

		//SMALLER CALLER – Still a potential palindrome, so check next 2 letters
		else
			return pal (p, left+1, right-1);
	}//pal
  
  public static boolean pal1 (String p1)
  //TASK: Return true if p is a palindrome (reads the same forwards as backwards)
  //HINT: You will need to use the substring method
  {
	  //Base Case 1
	  if (p1.length() <= 1)
		return true;
	  //Base Case #2
	  else if (p1.charAt(0) != p1.charAt(p1.length()-1))
		return false;	  
	  //Smaller Caller
	  else
		  return pal1 (p1.substring(1,p1.length()-1));
  }//pal1
  
  //24.
  public static int foo( String s, char c )
  {
	  //Base Case #1
	  if ( s.length( ) == 0 )
		return 0;
	  //Base Case #2
	  else if (s.charAt(0) == c)
	    return 1+foo(s.substring(1,s.length()),c);
	  //Smaller Caller
	  else
		return 0+foo(s.substring(1,s.length()),c);  
  }//foo
  
  //25.
  public static String foo1( String s1 )
  {
	  //Base Case #1
	  if ( s1.length( ) == 0 )
		  return "even";
	  //Base Case #2
	  else if ( s1.length( ) == 1 )
		  return "odd";
	  //Smaller Caller
	  else
		  return foo1(s1.substring(1,s1.length()));
  }//foo1
  
  //26.
  public static int foo2( int n )
  {
	  // n is guaranteed to be >= 0
	  //Print Statement
	  System.out.println( "n is: " + n);
	  //Base Case #1
	  if ( n == 0 )
		  return 0;
	  //Base Case #2
	  else if ( n == 1 )
		  return 1;
	  //Smaller Caller
	  else
		  return n + foo2(n-1) ;
  }//foo2
  
  //27.
  public static boolean foo3 ( String s2 )
  {
	  //Base Case #1
	  if (s2.length() == 0 || s2.length() == 1)
		return false;  
	  //Base Case #2
	  else if (s2.charAt(1) == s2.charAt(s2.length()-1))
		return true; 
	  //Smaller Caller
	  else
		return foo3( s2.substring( 1, s2.length( ) ) );
  }//foo3
  
  //28.
  public static int foo4 ( int n2 )
  {
	  //n is guaranteed to be greater than 1
	  //Print Statement
	  System.out.println( "n2 is: " + n2);
	  //Base Case
	  if ( n2 >= 1000 )
		  return n2;
	  //Smaller Caller
	  else
		  return foo4(n2*n2);
  }//foo4

  public static void main (String[] args) 
  { 
    //----------------------------------------------------------------- 
    // The following code tests method power.  The code reads in values 
    // for x and y, and computes x to the power y. 
    //----------------------------------------------------------------- 
    int x;
    int y; 
    String p = "cat";
    String s = "one";
    String s1 = "david";
    int n;
    String s2 = "abcdefg";
    int n2;
    //////// READ IN VALUES FOR x AND y //////////
    x = Integer.parseInt (JOptionPane.showInputDialog("Enter a value for x")); 
    y = Integer.parseInt (JOptionPane.showInputDialog("Enter a value for y"));
    n = Integer.parseInt (JOptionPane.showInputDialog("Enter a value for n"));
    n2 = Integer.parseInt (JOptionPane.showInputDialog("Enter a value for n2"));
    //////// CALL THE power METHOD WITH x AND y AND DISPLAY RESULT //////////
    JOptionPane.showMessageDialog (null, "x to the power y equals: " + power(x,y));
    //////// CALL THE Multiply METHOD////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "x times y equals: " + Multiply(x,y));
    //////// CALL THE pal METHOD/////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "P is a palindrome: " + pal(p, 0, p.length() - 1));
    //////// CALL THE pal1 METHOD////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "P1 is a palindrome: " + pal1(p));
    //////// CALL THE foo METHOD/////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "foo: " + foo(s,'o'));
    //////// CALL THE foo1 METHOD////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "foo1: " + foo1(s1));
    //////// CALL THE foo2 METHOD////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "foo2: " + foo2(n));
    //////// CALL THE foo3 METHOD/////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "foo3: " + foo3(s2));
    //////// CALL THE foo4 METHOD/////////////////////////////////////////////
    JOptionPane.showMessageDialog (null, "foo4: " + foo4(n2));
    
    
  } // main method

} // class RecursionTest
