// The "DictHashEntry" class. 
// This is an entry for a dictionary implemented using hashing. 
package hash;
public class DictHashEntry 
{ 
    protected Object key;         // The entry's key. 
    protected Object element;     // The entry's data. 
    protected DictHashEntry next; // The link to the next entry. 
 
    public DictHashEntry (Object key, Object element) 
    { 
    //PRE: init<key>, init<element> 
    //POS: this.key <-- key, this.element <-- element, next <-- null 
    //TAS: Create a new dictionary entry. 
       this.key = key; 
       this.element = element; 
       next = null; 
    } // DictHashEntry constructor 
 

    public Object getKey () 
    //PRE: NA 
    //POS: NA 
    //TAS: Return the entry's key. 
    { 
      return key; 
    } // getKey method

    public Object getElement () 
    //PRE: NA 
    //POS: NA 
    //TAS: Return the element of the link entry. 
    { 
      return element; 
    } // getElement method

    public void setElement (Object element) 
    //PRE: init<element> 
    //POS: this.element <-- element 
    //TAS: Set the element of the link entry. 
    { 
      this.element = element; 
    } // setElement method 
 

    public DictHashEntry getNext () 
    //PRE: NA 
    //POS: NA 
    //TAS: Return the link to the next link entry. 
    { 
       return next; 
    } // getNext method

    public void setNext (DictHashEntry newNext) 
    //PRE: init <newNext> 
    //POS: next <-- newNext 
    //TAS: Set the link to the next link entry. 
    { 
       next = newNext; 
    } // setNext method 
} /* DictHashEntry class */