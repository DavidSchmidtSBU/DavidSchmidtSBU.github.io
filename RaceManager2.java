package racers;

// The "RaceManager2" class.
// This class is an applet that sets up three racers and then starts them
// running. When one racer finishes the race, it calls the finish method
// which stops the other two racers.
import java.applet.*;
import java.awt.*;

 
public class RaceManager2 extends Applet
{
Racer2 racer1, racer2, racer3; // The three racers
// Called by the system when the applet is first initialized.
public void init ()
{
    // Create the three racers, but do not start racing.
racer1 = new Racer2 (this, 50, Color.green);
racer2 = new Racer2 (this, 150, Color.red);
racer3 = new Racer2 (this, 250, Color.blue);
} // init method

 
// Called by the system when the applet is first activated.
public void start ()
{

 
setVisible (true); // Make the applet's surface visible.
// Call the racers' run method (start the racing).
racer1.start ();
racer2.start ();
racer3.start ();
} // start method
// Called by the system when the applet needs to be repainted.
public void paint (Graphics g)
{
racer1.paint ();
racer2.paint ();
racer3.paint ();
} // paint method
// This method is called by a Racer2 object when it has reached the
// right side of the screen. It is synchronized so that only one
// thread can "win" at a time. The finished method kills the other
// two threads so that even if the other threads are waiting to
// execute this method, (i.e. they finished "just" after the winning
// thread) they are killed before they can do so.
public synchronized void finished (Racer2 winner)
{
if (winner == racer1)
{
racer2.stop ();
racer3.stop ();
showStatus ("Winner was: Green"+racer1+"Second place was: Red"+racer2+"Third place was: Blue"+racer3);
}
else if (winner == racer2)
{
racer1.stop ();
racer3.stop ();
showStatus ("Winner was: Red"+racer2+"Second place was: Green"+racer1+"Third place was: Blue"+racer3);
}
else
{
racer1.stop ();
racer2.stop ();
showStatus ("Winner was: Blue"+racer3+"Second place was: Red"+racer2+"Third place was: Green"+racer1);
}
} // finished method
} /* RaceManager2 class */