package Practice.JavaBasics;

// If the method are equally specific but in different class hierarchies, it results in a compilation Error.
public class NullExample {
    public static void main(String[] args){
        testMethod(null);
    }

    public static void testMethod(Object value){
        System.out.println("object"+value);
    }

    // it will print Double
    public static void testMethod(Double value){
        System.out.println("Double "+value);
    }
    
}
