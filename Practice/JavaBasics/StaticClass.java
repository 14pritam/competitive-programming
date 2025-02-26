package Practice.JavaBasics;

class Car {
    String model;

    Car(String model) {
        this.model = model;
    }
}

public class StaticClass {

    /*
     1. They belong to the class itself, not to any specific object. You can call them directly using the
        class name without creating an object.
     2. Static methods are loaded into memory once when the class is loaded, regardless of how many objects
        are created from that class.
    
    Static Variable with an Object
		When you declare an object as static, it means:
	1.	The object is shared across all instances of the class.
	2.	It is created once when the class is loaded and exists until the program ends.
	3.	You can access it without creating an object of the class.
    
     */

    static Car staticCar;  // Static object reference

    static {
        // Static block to initialize the static object
        staticCar = new Car("Ferrari");
        System.out.println("Static block executed");
    }

    public static void displayCar() {
        System.out.println("Car model: " + staticCar.model);
    }

    public static void main(String[] args) {
        displayCar();  // Call static method directly without creating an object
    }
}