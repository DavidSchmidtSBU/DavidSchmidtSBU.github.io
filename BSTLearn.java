
package binSrchTree;
// The "BSTLearn" class.

public class BSTLearn
{
  public static void main(String[] args)
  {
    //Create the empty tree
    BinSrchTree SearchTree = new BinSrchTree();
     
    //Create some person objects to put in the tree
    Person a = new Person("Sue", 48);
    Person b = new Person("Tim", 44);
    Person c = new Person("Rachel", 22);
    Person d = new Person("Jim", 18);
    Person e = new Person("Sid", 18);
    Person f = new Person("Sue", 48);
    Person g = new Person("Tim", 44);
    Person h = new Person("Rachel", 22);
    Person i = new Person("Jim", 18);
    Person j = new Person("Sid", 18); 
    //Insert the persons in the tree and display the depth as it changes
    SearchTree.insert("A", a);
    SearchTree.insert("B", b);
    SearchTree.insert("C", c);
    SearchTree.insert("D", d);
    SearchTree.insert("E", e);
    SearchTree.insert("F", f);
    SearchTree.insert("G", g);
    SearchTree.insert("H", h);
    SearchTree.insert("I", i);
    SearchTree.insert("J", j);
    //Display the contents of the tree
    SearchTree.printTree();
    //How tall is the tree now?
    System.out.println(SearchTree.depth());
    System.out.println(SearchTree.height());
  } // main method  
}/* BSTLearn class */