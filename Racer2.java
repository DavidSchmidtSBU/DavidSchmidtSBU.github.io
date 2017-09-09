package racers;

// The "Racer2" class.
// Located in: Examples\Ch16\Racer2.java
// A Racer2 object represents one racer used by the RaceManager2 class on
// which it should draw. (RaceManager2 must be a subclass of Component.)
// Note that this Racer2 only works in conjunction with the
// RaceManager2 class.
import java.applet.*;
import java.awt.*;
public class Racer2 extends Thread
{
// The calling object (which must be of type RaceManager2).
protected RaceManager2 race;
protected int x; // The current x coordinate of the racer.
protected int y; // The y coordinate at which the racer should be drawn.
// The color with which the racer should be drawn.
protected Color color;
// Initialize the Racer2 object with the drawing surface, the y
// coordinate at which to draw the racer, and the color with which
// to draw the racer. Do not start the racer moving yet.
public Racer2 (RaceManager2 race, int y, Color color)
{
    this.race = race;
    this.y = y;
    this.color = color;
} // Racer2 constructor
 
// Called when the start method is called for the Racer2 object.
// It loops until the racer reaches the right side of the drawing
// surface. Each iteration through the loop, the Racer2 object
// sleeps for between 0 and 29 milliseconds and then advances
// one pixel.
public void run ()
{
        Graphics g = race.getGraphics ();
        // In case we add the ability to run the race several times,
        // wipe out any drawing already extant and set x to zero.
        x = 0;
        g.clearRect (0, y, race.getSize ().width, 30);
        // Set the drawing to the racer's color.
        g.setColor (color);
        // Loop until the racer reaches the right side of the screen.
        while (x < race.getSize ().width)
        {
                // Delay for 0-29 milliseconds. 
                try 
                { 
                    Thread.sleep ((int) (Math.random () * 30)); 
                } 
                catch (InterruptedException e) 
                {
// This exception will not happen in our program, but
// Java requires that we handle it anyway.
System.out.println ("Sleep interrupted.");
      }
                // Draw the racer at its new position and advance x.
                g.drawLine (x, y, x, y + 30);
                x += 1;
        }//while
 
    // Call the calling object's finished method with itself as
    // as a parameter to notify the RaceManager2 object which
    // Racer2 won.
    race.finished (this);
} // run method
// Called if the racer needs to be redrawn. It should be called
// by the Applet or Frame that needed to be repainted.
public void paint ()
{
Graphics g = race.getGraphics ();
g.setColor (color);
g.fillRect (0, y, x, 30);
} // paint method
} /* Racer2 class */

  
  