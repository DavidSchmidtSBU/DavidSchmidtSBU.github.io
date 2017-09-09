package shapes;

import java.awt.*; 
// Represents a square of specific size & color, drawn // in a particular location. 
 public class Square extends Rectangle  
{
 // Specifies location and size, defaults color. 
  public Square (int x, int y, int sides) 
  //PRE: init<x, y, sides> 
  //POS: this.x <- x, etc. 
  //TAS: Create a square object at x, y with sides specified 
  { 
   super(x,y,sides,sides);  
  } // constructor Square
  public Square ( Color color, int x, int y, int sides) 
  // PRE: init<color, x, y, sides> 
  // POS: this.x <- x, etc. 
  // TAS: Specifies location, size, and color for this square 
  { 
   super(color,x,y,sides,sides);  
  } // constructor Square 
} // class Square
  