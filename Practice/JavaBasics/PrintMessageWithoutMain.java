package Practice.JavaBasics;

// Print Message  without main method

class Test {
    static {
        System.out.println("Hello, World!");
        System.exit(0); // Exits to prevent JVM errors
    }
}

public class PrintMessageWithoutMain {
    public static void main(String[] args) {
        try {
            Class.forName("Practice.Java8Features.Test"); // Use fully qualified class name
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}