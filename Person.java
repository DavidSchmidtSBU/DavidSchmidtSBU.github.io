package binSrchTree;
class Person 
{ 
  
  protected String name; 
  protected int age; 
  public Person (String n, int a) 
  { 
    name = n; 
    age = a; 
  } // Person constructor 

  public int compareTo (Person other) 
  { 
    return name.compareTo (((Person) other).name); 
  } // compareTo method 

  public String getName () 
  { 
    return name; 
  } // toString method 

  public int getAge () 
  { 
    return age; 
  }

} /* Person class */ 