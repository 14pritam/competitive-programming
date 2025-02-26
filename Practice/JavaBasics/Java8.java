package Practice.JavaBasics;

import java.util.function.Function;
import java.util.function.Predicate;

/*
  
  Functional Interface 

  

  Lambda Expression



  Streams in Java 8

  
 */
interface Operation {

    int increment(int num);
    
}


class OperationImpl implements Operation {

    @Override
    public int increment(int num){
        return num++;
    }
}
public class Java8{

    public static void main(String[] args){

        // To Run Java Program
        // javac Java8.java
        // java Java8
        
        // Function 
        Function<Integer, Integer> fun = value -> value * value;
        System.out.println("The Square of 2: " + fun.apply(2)); // The Square of 2: 4

        //Predicate
        Predicate<Integer> pre = value -> value%2 ==0;
        System.out.println(pre.test(4));

        // without using lambda expression
        Operation operation = new OperationImpl();
        System.out.println(operation.increment(10));

        // Another way using Lambda expression
        Operation operation2 = 
            (int num)->{
                return  num + 20;
            };

        System.out.println(operation2.increment(20));

        // more smaller Lambda expression

        Operation operation3 = num -> num+30;

        System.out.println(operation3.increment(100));

        /* 
        Functional Interface in java

         
         */

    }

}