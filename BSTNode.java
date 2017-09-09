package binSrchTree;
public class BSTNode 
{ 
protected String key; 
protected Object element; 
protected BSTNode left, right;
protected int height = 0;
public BSTNode (String key, Object element, BSTNode left, BSTNode right, int height) 
{ 
  this.key = key; 
  this.element = element; 
  this.left = left; 
  this.right = right; 
  this.height = height;
} // BSTNode constructor 

public String getKey () 
{ 
  return key; 
} // getKey method 

public Object getElement () 
{ 
  return element; 
} // getElement method 

public BSTNode getLeft () 
{ 
  return left; 
} // getLeft method 

public BSTNode getRight () 
{ 
  return right; 
} // getRight method 

public void setElement (Object element) 
{ 
  this.element = element; 
} // setElement method 

public void setLeft (BSTNode node) 
{ 
  left = node; 
} // setLeft method 

public void setRight (BSTNode node) 
{ 
  right = node; 
} // setRight method

public int getHeight ()
{
  return height;
} // getHeight method

public void setHeight (int height)
{
   this.height = height;  
} // setHeight method

} /* BSTNode class */ 