package sortingPackage;
import java.util.Random;
public class FunWithSorting  
{

 public static void print (int [] n)
 //TASK: Displays an array
 {
   for (int i = 0; i < n.length; i++)
     System.out.print (n[i] + " ");
   System.out.println();
 }//print
 
 public static void sort(int[] numbers, int array_size)
 //TASK: Sorts an array
 {
   //put your sorting algorithm here
	 int i, j, temp;
	 int count = 0;
	  for (i = (array_size - 1); i >= 0; i--)
	  {
	    for (j = 1; j <= i; j++)
	    {
	      if (numbers[j-1] > numbers[j])//Swap
	      {
	        temp = numbers[j-1];
	        numbers[j-1] = numbers[j];
	        numbers[j] = temp;
	        count++;
	      }//if
	    }//for
	  }//for
	  System.out.println(count);
 }//end of sorting method
    public static void insertionSort( int numbers [ ] )
    {
    	int temp;
    	int j;
    	int counter = 0;
    	for ( int i = 1; i < numbers.length; i++ )
    	{
    		j = i;
    		temp = numbers[i];
    		
    		while ( j != 0 && numbers[j-1] > temp )
    		{
    			numbers[j] = numbers[j-1];
    			j--;
    			counter++;
    		}
    		
    		numbers[j] = temp;
    	}
    	System.out.println(counter);
    }

 public static void main(String[] args) 
 {
   int [] numArray = new int [10000];
   Random rand = new Random( );
   for ( int i = 0; i < numArray.length; i++ )
   {
	   numArray[i] = rand.nextInt ( 10000 ) + 1;
   }
   print (numArray);
   insertionSort (numArray);
   print (numArray);

 }//end main

}//end FunWithSorting
