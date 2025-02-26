package Practice.Array;

public class MethodHiding {

    static class Parent {
        static void show() { // Static method
            System.out.println("Parent's show()");
        }
    }

    static class Child extends Parent {
        static void show() { // Hiding the method
            System.out.println("Child's show()");
        }
    }

    public static void main(String[] args) {
        Parent obj = new Child(); // Reference type is Parent, actual object is Child
        obj.show(); // Calls Parent's show() because method hiding depends on reference type
    }
}