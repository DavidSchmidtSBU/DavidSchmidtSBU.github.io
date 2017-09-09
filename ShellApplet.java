package Lab4;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Color;

public class ShellApplet extends JApplet 
{
  public void paint( Graphics g)
  {
   super.paint( g );
   
   //16. This code sets the current color to red.
   g.setColor(Color.RED );
   //17. This code draws the string 'Fill In the Code' with the lower-left corner of the first character (the F) being at the coordinate (100,250).
   g.drawString( "Fill In the Code", 100, 250 );
   //18. This code draws a filled rectangle with a width of 100 pixels and a height of 300 pixels, starting at the coordinate (50,30).
   g.fillRect( 50, 30, 100, 300 );
   //19. This code draws a filled rectangle starting at (50,30) for its upper-left corner with a lower-right corner at (100,300).
   g.fillRect( 50, 30, 50, 270 );
   //20. This code draws a circle of radius 100 with its center located at (200,200).
   g.drawOval( 200 - 100, 200 - 100, 100 * 2, 100 * 2);
   //21. Where is the error in this code sequence?
   Graphics g = new Graphics( );
   Graphics g = new Graphics( g ); //Put g in ().
   //22. Where is the error in this code sequence?
   g.drawString( 'Find the bug', 100, 200 );
   g.drawString( "Find the Bug", 100, 200 );//Bug needs to be Upper-Cased.
   //23. Where is the error in this code sequence?
   g.setColor( GREEN );
   g.setColor(Color.GREEN);//Color needs to be in ().
   //24. Where is the error in this code sequence?
   g.setColor( Color.COBALT );
   g.setColor(Color.DARK_BLUE );//COBALT doesn't exist in this code.
   //25. Where is the error in this code sequence?
   g.setColor = Color.RED;
   g.setColor(Color.RED);//Needs to be in ().
   //26. Where is the error in this code sequence?
   import Graphics;
   import java.awt.Graphics;//Needs the java.awt in it.
   //27. Where is the error in this code sequence?
   import java.awt.JApplet;
   import javax.swing.JApplet;//Needs to be javax.swing, not java.awt.
  }
}

