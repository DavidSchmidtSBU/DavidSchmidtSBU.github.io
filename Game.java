package game;
import java.util.Random;
public class Game
{
  private Grid grid; //Holds the gird used to store and display images
  private int userRow; //Keeps track of which row the image appears in, on the left edge of grid
  private int msElapsed; //Keeps track of the total number of milliseconds that have passed 
  private int timesGet; //Keeps track of the total number of times the user has gotten the things
  private int timesAvoid; //Keeps track of the total number of times the user has been hit
  
  public Game()
  {
    grid = new Grid(10, 20);
    userRow = 1;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), "get.gif");
  }
  
  public void play()
  {
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress()
  {
	  int key = grid.checkLastKeyPressed();
	  grid.setImage(new Location(userRow, 0), null); 
	  if (key == 38)
		 userRow--;
	  else if (key == 40)
		 userRow++;
	  if (userRow < 0)
		 userRow = 0;
	  else if (userRow > 9)
		 userRow = 9;
	  grid.setImage(new Location(userRow, 0), "get.gif"); 
  }
  
  public void populateRightEdge()
  {
	  Random rand = new Random();
	  int prot = rand.nextInt(9)+1;
	  if (prot < 5)
	  {
		 int getpos = rand.nextInt(9)+1;
		 grid.setImage(new Location(getpos, 19), "get.gif");
	  }
	  else
	  {
		int avoidpos = rand.nextInt(9)+1;  
		grid.setImage(new Location(avoidpos, 19), "avoid.gif");
	  }
  }
  
  public void scrollLeft()
  {
	  for (int i = 0; i < 19; i++)
	  {
		  
	  }
  }
  
  public void handleCollision(Location loc)
  {
  }
  
  public int getScore()
  {
    return 0;
  }
  
  public void updateTitle()
  {
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver()
  {
    return false;
  }
  
  public static void test()
  {
    Game game = new Game();
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}