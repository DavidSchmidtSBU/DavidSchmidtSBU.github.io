package binSrchTree;
import java.util.*;  //imports the Iterator interface

public  class BSTIterator implements Iterator
{

   private int current;  // the current position of the iterator
   private int count;    // the size of the array
      //personList is an array to hold references to Person Objects
   private Person [] personList; 
   
   public BSTIterator (BSTNode tree, int size)
   //PRE: None
   //POS: personList.length == tree.size()
   //TAS: Initialize the iterator.  
   //     Store references to the tree nodes in an array of Persons. 
   //     We will call a recursive helper method to traverse
   //     the tree and copy the references into the array.
   {
      current = 0;
      count = 0;
      personList = new Person[size];
      recCopy (tree);
   }//BSTIterator

   private void recCopy(BSTNode node)
   //PRE: None
   //POS: personList[0..size] != null
   //TAS: Recursively store references to Person objects
   //     into the personList array
   {
       if (node == null)
         return;
       recCopy (node.getLeft ());
       personList[count] = (Person)node.getElement();
       count++;
       recCopy (node.getRight ());
    }//recCopy

   public boolean hasNext()
   //PRE: none
   //POS: none
   //TAS: return true if there are more nodes to visit
   {
      return (current < personList.length);
   }//hasNext

   public Person next()
   //PRE: none
   //POS: current<exit> == current<entry>+1
   //TAS: return the next item in the tree
   {
       Person p = personList[current];
       current++;
       return p;
   }//next

   public void remove() throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }//remove
   
}//BSTIterator
