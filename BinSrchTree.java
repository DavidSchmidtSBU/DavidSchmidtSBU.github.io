
// This is a BST Dictionary implementing a recursive algorithm for 
// search, insertion, deletion, printing, and determining maximum 
// depth. 
package binSrchTree;
import java.util.*;
public class BinSrchTree{ 
protected int height = 0;	
private int count;
private BSTNode tree; // The root of the Binary Search Tree. 
public BinSrchTree () 
//PRE: None 
//POS: tree == null 
//TAS: Initialize the Binary Search tree to null 
{ 
    tree = null; 
} 

boolean isEmpty () 
//PRE: None 
//POS: None 
//TAS: return tree being equal to null 
{ 
    return tree == null; 
} // isEmpty method 

public Object search (String key) 
//PRE: init<key> 
//POS: none 
//TAS: Search the tree for object with key 
// if (object with this key is in the tree) 
// return a reference to the object 
// else 
// return a null reference 
{ 
    BSTNode node = recSearch (tree, key); 
    if (node == null) 
    { 
      return null; 
    } 
    else 
    { 
      return node.getElement (); 
    } 
} // search method 

private BSTNode recSearch (BSTNode node, String key) 
//PRE: 
//POS: 
//TAS: Currently, this method is stubbed; it is returning 
// null because it has to return something. 
{ 
    return null; 
} // recSearch method 

public void insert (String key, Object element) 
//PRE: init <key>, init<element> 
//POS: exit <tree> <-- entry <tree> + element 
//TAS: insert the object with key into the tree 
{ 
    tree = recAVLInsert (tree, key, element, height()); 
} // insert method 

private BSTNode recInsert (BSTNode node, String key,Object element) 
//PRE: 
//POS: 
//TAS: 
{ 
    if (node == null) 
    { 
      node = new BSTNode (key, element, null, null, 0);
      count++;
    } 
    else if (key.compareTo (node.getKey ()) == 0) 
    { 
      node.setElement (element);
    } 
    else if (key.compareTo (node.getKey ()) < 0) 
    { 
      node.setLeft (recInsert (node.getLeft (), key, element)); 
    } 
    else 
    { 
      node.setRight (recInsert (node.getRight (), key, element)); 
    } 
    return node; 
} // recInsert method 

public void delete (String key) 
//PRE: init <key> 
//POS: exit<tree> = entry<tree> - node<key>
//TAS: Call the recursive delete method with tree and key
{ 
    tree = recDelete (tree, key); 
} // delete method 

private BSTNode recDelete (BSTNode node, String key) 
//PRE: init <node>, init<key>
//POS: exit<tree> = entry<tree> - node<key>
//TAS: Find the node to delete and call remove if found 
{ 
	if (node == null) { 
        System.out.println ("Unable to find node with key."); 
        return null; 
    } 
    else if (key.compareTo (node.getKey ()) == 0) { 
        node = remove (node); 
    } 
    else if (key.compareTo (node.getKey()) < 0) { 
        node.setLeft (recDelete (node.getLeft (), key)); 
    } 
    else { 
        node.setRight (recDelete (node.getRight(), key)); 
    } 
    return node;
} // recDelete method 

private BSTNode remove (BSTNode node) 
//PRE: node points to delete node
//POS: exit<tree> = entry<tree> - node<key>
//TAS: Delete the node and reattach subtrees of deleted node
{ 
	BSTNode here = node; 
    if (node.getLeft() == null) {       // CASE 1: Right Child Only 
        return node.getRight();         // attach right subtree 
    } 
    else if (node.getRight() == null){  // CASE 2: L.Child Only 
        return node.getLeft();          // attach left subtree 
    } 
    else {                              // CASE 3: both L & R children 
        node = node.getRight ();        // point to right child 
        BSTNode temp = node;            // set temp to node 
        while (temp.getLeft() != null)  // find node in right 
            temp = temp.getLeft();      // subtree w largest key 
        temp.setLeft (here.getLeft());  // attach left subtree 
        return node;                    // quit 
    }//else 	
} // remove method 

public void printTree () 
//PRE: 
//POS: 
//TAS: 
{ 
    recPrintTree (tree); 
} // printTree method 

private void recPrintTree (BSTNode node) 
//PRE: 
//POS: 
//TAS: 
{ 
    if (node == null) 
      return; 
    recPrintTree (node.getLeft ()); 
    System.out.println (node.getKey ()); 
    recPrintTree (node.getRight ()); 
} // recPrintTree method 

public int depth () 
//PRE: 
//POS: 
//TAS: 
{ 
    return recDepth (tree); 
} // depth method 

protected int recDepth (BSTNode node) 
//PRE: 
//POS: 
//TAS: 
{ 
    if (node == null) 
    { 
         return 0; 
    } 
    else 
    { 
        return 1 + Math.max ( recDepth (node.getLeft ()), recDepth (node.getRight ())); 
    } 
} // recDepth method

public int size ()
{
	return count;
}//size method

public BSTIterator Iterator ()
{
	return new BSTIterator(tree, count);
}

private int height ( BSTNode node )
//PRE: none
//POS: none
//TAS: if the node is null return 1, else return the height in the node
{
	return node == null ? -1 : node.getHeight();
}

private int max (int lhs, int rhs)
//PRE: none
//POS: none 
//TAS: return the larger of left height of subtree (lhs) and rhs
{
	return lhs > rhs ? lhs : rhs;
}

public int height()
{
	return height(tree);
}

private BSTNode singleRightRotation( BSTNode k2 )
//TASK: Rotate the left child up and to the right to become the new root of this subtree
{
	BSTNode k1 = k2.left;
	k2.left = k1.right;
	k1.right = k2;
	k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
	k1.height = max( height( k1.left ), k2.height ) + 1;
	return k1;
}//singleRightRotation

private BSTNode singleLeftRotation( BSTNode k1 )
//TASK: Rotate the right child up and to the left to become the new root of this subtree
{
	BSTNode k2 = k1.right;
	k1.right = k2.left;
	k2.left = k1;
	k2.height = max( height( k1.left ), height( k1.right ) ) + 1;
	k1.height = max( height( k2.right ), k1.height ) + 1;
	return k2;
}//singleRightRotation

private BSTNode doubleLeftRightRotation( BSTNode k3)
//TASK: Rotate the left subtree to the left, then up and to the right to become
//      the new root of this subtree
{
	k3.left = singleLeftRotation( k3.left );
	return singleRightRotation( k3 );
}

private BSTNode doubleRightLeftRotation( BSTNode k4 )
//TASK: Rotate the right subtree to the right, then up and to 
//      the left to become the new root of this subtree
{
    k4.right = singleRightRotation( k4.right );
    return singleLeftRotation( k4 );
}

private BSTNode recAVLInsert (BSTNode node, String key,Object element, int height) 
{ 
  if (node == null) // then we reached an empty spot in the tree, so insert here
    node = new BSTNode (key, element, null, null, 0); 

  else if (key.compareTo (node.getKey ()) < 0)    // key < node.key so search in LEFT subtree 
  { 
     // Shown below is just a recursive call to this method to insert in LEFT subtree
     node.setLeft (recAVLInsert (node.getLeft (), key, element, height));	 

     // AFTER inserting, it is possible the tree is out of balance, so check subtree heights
     if(height(node.getRight())- height(node.getLeft()) == -2)//if true, L. subtree too long

       //Now we must decide what sort of rotation will fix the problem 
       if(key.compareTo( node.getLeft().getKey()) < 0 ) // Inserted into L subtree of L child
          node = singleRightRotation( node );           // Fix with a Single Right Rotation
       else                                             // Inserted into R subtree of L child
          node = doubleLeftRightRotation( node );       // So Double Rotation is necessary
  }//else if 

  else               				      // key > node.key so search in RIGHT subtree
  { 
     // Shown below is simply the mirror image of what we did above
     node.setRight (recAVLInsert (node.getRight (), key, element, height)); 
     if( height( node.getRight() ) - height( node.getLeft() ) == 2 )
       if( key.compareTo( node.getRight().getKey()) > 0 )
           node = singleLeftRotation( node );
       else
           node = doubleRightLeftRotation( node );
  }//else 

  //We are done, but now we need to reset the height of this node after the insertion	
  node.setHeight(max( height(node.getLeft()), height(node.getRight())) + 1);
  return node; 
} // recAVLInsert method

} /* BSTDictionary class */ 