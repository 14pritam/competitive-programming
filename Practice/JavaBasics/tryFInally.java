package Practice.JavaBasics;

public class tryFInally {
        
       /*
         Yes, it is possible to execute code without a try block, 
         but using try ensures that exceptions are handled properly. If you use try, 
         you can also use finally to execute cleanup code, whether an exception occurs or not.
       */
      public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            int x = 10 / 2;  // If an exception occurs, jumps to finally
            System.out.println("Result: " + x);
        } finally {
            System.out.println("This will always execute, regardless of an exception.");
        }

      /*
        • try-finally has minimal impact if no exceptions occur.
        • try-catch slows performance if exceptions are frequent.
	    • Avoid using exceptions for logic control—use conditionals instead.
      */

      /*
            Overhead refers to the extra computational cost (time, memory, or processing) required to
            manage a process beyond its core function. It does not directly contribute to the main task but
            is necessary for execution.
          */

          /*
           The finally block almost always executes, but there are a few rare cases where it does not execute.
           When System.exit(0) is Called The JVM shuts down immediately, skipping finally.
           */
          try {
            System.out.println("Inside try");
            System.exit(0);  // Terminates the JVM
        } finally {
            System.out.println("Inside finally"); // Not executed
        }
        /*
          No, Java does not allow multiple finally blocks for a single try block. Each try block can have only one finally block.
         */

         /*
          Handling Multiple Exceptions in a Single Try-Catch in Java
          1. You can combine multiple exceptions in a single catch block using | (pipe operator).
          */
          try {
            int a = 10 / 0;  // ArithmeticException
            int[] arr = new int[5];
            arr[10] = 50;  // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        /*
          We can’t run a Java application without installing JRE because it has essential tools and libraries 
          the application needs. But there is a tool called jlink in newer Java 9 versions that lets us bundle
          a custom minimal JRE with our application, so it can run without requiring a separately installed JRE.
          Additionally, with GraalVM, we can compile Java applications into native executables, eliminating the 
          need for a JRE altogether.
        */

      /*
         Is it possible to have JDK installed without having the JRE ?  

         NO JDK contains the JRE. It's impossible to have JDK without JRE. as it contains essential components 
         for running Java application, which JDK also use for development.

         ----
         Can you tell me what algorithm JVM uses for Garbage Collection ?

         Mark-and-Sweep , Mark Compact , Generational Copying depending on the collector chosen.

         -----
         How can memory leak occurs in java even if we have automatic java Garbage collection ?

         Memory leak in java Occurs when Object are no longer needed but still refrence from other reachable Objects,
         and hence preventing the Garbage collector from reclaiming the memory.

         -----
         Is java 100 % Object Oriented Programming Language.

         NO , becoz it uses primitive objects like (char,int,etc)
         In fully Object oriented Programming everthing is treated as Objects.

         -----
         what are the advantages of java being partially object oriented programming.






      */
    }
    
}
