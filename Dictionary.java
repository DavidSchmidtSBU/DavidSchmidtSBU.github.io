// The "Dictionary" class. 
// The Dictionary class implemented using hashing. Hash buckets are 
// used. A dictionary contains a set of data elements with corresponding 
// keys. Each element is inserted into the dictionary with a key. Later 
// the key can be used to look up the element. Using the key, an element 
// can be changed or it can be deleted from the dictionary. There is also 
// an operation for checking to see if the dictionary is empty. 
package hash;
public class Dictionary 
{ 
    protected final static int MAX_BUCKETS = 1000;  // number of buckets 
    protected DictHashEntry[] buckets; // the bucket array
    protected int collisionCount = 0; //Counts the collisions 
    protected int threshold = 500; //Doubles the array if needed to
    public Dictionary () 
    //PRE: NA 
    //POS: buckets[0..MAX_BUCKETS] <-- null 
    //TAS: Create a new dictionary. Create the bucket array. 
    { 
     buckets = new DictHashEntry [MAX_BUCKETS]; 
     for (int i = 0 ; i < MAX_BUCKETS ; i++) 
     { 
       buckets [i] = null; 
     }//for i -> MAX_BUCKETS 
    } // Dictionary constructor

    public int collisions () 
    //PRE: NA 
    //POS: NA 
    //TAS: Return the number of collisions in the dictionary 
    {
      return collisionCount;
    }// method collisions 
    
    public int mean ()
    //PRE: !isEmpty
    //POS: NA
    //TASK: Return the mean length of the bucket lists.
    {
      return MAX_BUCKETS/1000; 
    }//mean
    
    public void resize ()
    {
      	if (collisionCount >= threshold)
      		MAX_BUCKETS = MAX_BUCKETS * 2;
    }//resize
    
    protected int hash (Object key) 
    //PRE: init <key> 
    //POS: NA 
    //TAS: Hash the key to a number between 0 and MAX_BUCKETS - 1. To 
    // do this we use the built-in method "hashCode" for Object. 
    // "hashCode" returns an integer that must be changed into a value 
    // between 0 and MAX_BUCKETS - 1. 'And'ing the value with 
    // 0x7FFFFFFF makes it a positive value. 
    { 
     return (key.hashCode () & 0x7FFFFFFF) % MAX_BUCKETS; 
    } // hash method

    protected DictHashEntry find (Object key) 
    //PRE: init <key> 
    //POS: result == null or key.equals (result.getKey ()) 
    //TAS: Find node whose key matches the key parameter. Return null if 
    // not found. This method is used internally and is not exported. 
    { 
     DictHashEntry node = buckets [hash (key)];
     if (node != null)
    	collisionCount++;
     while ((node != null) && (!key.equals (node.getKey ()))) 
     { 
       node = node.getNext (); 
     }

     return node; 
    } // find method 
 
    public Object put (Object key, Object element) 
    //PRE: init<key>, init<element> 
    //POS: exit<dictionary> <-- entry<dictionary> + new<element> 
    //TAS: Add the element with its key to the dictionary. If the key is 
    // already in the dictionary, the element is changed to the new 
    // element and the old element is returned. Otherwise put returns 
    // null. 
    { 
     DictHashEntry where = find (key);

     if (where == null) 
     { 
       DictHashEntry node = new DictHashEntry (key, element); 
       int bucketNumber = hash (key); 
       node.setNext (buckets [bucketNumber]); 
       buckets [bucketNumber] = node; 
       return null; 
     } 
     else 
     { 
       Object previousElement = where.getElement (); 
       where.setElement (element); 
       return previousElement; 
     } 
    } // put method

    public Object remove (Object key) 
    //PRE: init<key> 
    //POS: exit<dictionary> <-- entry<dictionary> - element if element exists 
    //TAS: Remove key and its corresponding element from the dictionary. 
    // If the key was present, then delete the entry and return the entry's 
    // element, otherwise return null.

    { 
     DictHashEntry where = find (key);

     if (where == null) 
     { 
       return null; 
     } 
     else 
     { 
       int bucketNumber = hash (key); 
       if (key.equals (buckets [bucketNumber].getKey ())) 
       { 
        buckets [bucketNumber] = buckets [bucketNumber].getNext (); 
       } 
       else 
       { 
        DictHashEntry prev = buckets [bucketNumber]; 
        DictHashEntry next = prev.getNext (); 
        while (!key.equals (next.getKey ())) 
        { 
          prev = next; 
          where = next.getNext (); 
        } //while 
        prev.setNext (next.getNext ()); 
       } //else 
       return where.getElement (); 
     } //else 
    } // remove method

    public Object get (Object key) 
    //PRE: init <key> 
    //POS: NA 
    //TAS: Find the element with the key and return it. Return null if the key 
    // was not found.

    { 
     DictHashEntry where = find (key);

     if (where == null) 
     { 
       return null; 
     } 
     else 
     { 
       return where.getElement (); 
     } 
    } // get method

    public boolean isEmpty () 
    //PRE: NA 
    //POS: NA 
    //TAS: Return true if the dictionary contains no entries 
    { 
     for (int i = 0 ; i < MAX_BUCKETS ; i++) 
     { 
        if (buckets [i] != null) 
         { 
        return false; 
         } 
     } 
     return true; 
    } // isEmpty 
} /* Dictionary class */