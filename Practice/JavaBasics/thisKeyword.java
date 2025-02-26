package Practice.JavaBasics;

public class thisKeyword {
    /* 
     1. The this keyword in Java refers to the current object or instance of a class

    */
    

    /*
     * To Refer to the Current Instance Variable
     */
    int x,y;

    thisKeyword(int x, int y) {
        this.x = x;  // 'this.x' is the instance variable, 'x' is the local variable
        this.y = y;
    }


    /*
     * To Invoke the Current Class Method
     */
    void method1() {
        System.out.println("Method 1");
    }

    void method2() {
        this.method1();  // Calls method1()
    }

    /*
     * To Invoke the Current Class Constructor
     */

     thisKeyword() {
        this(10);  // Calls the constructor with int parameter
    }

    thisKeyword(int x) {
        System.out.println("Value: " + x);
    }

    /*
     * When to Use this Keyword?
	•	When there is name conflict between instance and local variables.
	•	For method chaining or constructor chaining.
	•	To pass the current object to another method or constructor.
	•	To make code more readable and explicit.
     */
}
