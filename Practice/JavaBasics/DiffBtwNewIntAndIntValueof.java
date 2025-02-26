package Practice.JavaBasics;

public class DiffBtwNewIntAndIntValueof {

    /**
     * What’s the Difference Among new Integer(“127”), Integer.valueOf(“127”) and Integer.valueOf(“128”) ?
     1. new Integer("127"):
	  •	Creates a new object every time it is called, regardless of the value.
	  •	Does not use caching.

     2. Integer a = Integer.valueOf("127");
        Integer b = Integer.valueOf("127");
        System.out.println(a == b);  // true (same cached object)
      • Uses the Integer Cache for values in the range -128 to 127.
	  •	Returns the same object from the cache for numbers within this range.

     3. Integer.valueOf("128"):
	  •	Does not use cache for values outside the range -128 to 127.
	  •	Returns a new object every time for values greater than 127 or less than -128. 
    */
public static void main(String[] args){

    Integer a = new Integer("127"); // always creates a new object in heap memory.
    Integer b = new Integer("127");
    System.out.println(a == b);  // false
    
    Integer c = 127; // returns a reference from the string pool if the string already exists, avoiding unnecessary object creation.
    Integer d = Integer.valueOf("127");
    System.out.println(c == d);  // true
    
    Integer e = Integer.valueOf("128");
    Integer f = Integer.valueOf("128");
    System.out.println(e == f);  // false

    /*
       Integer.valueOf(): Uses caching (for -128 to 127).
       
       String.valueOf(): Uses the string pool if the string already exists.

       new String(): Always creates a new String object`, even if the string already exists in the string pool.

       The String Pool (also known as String Intern Pool) is a special memory area in the Java heap that stores
       string literals to reduce memory usage and improve performance.

       A String literal is a sequence of characters enclosed in double quotes (") that is directly written in the code.

     */
}
}