package Practice.JavaBasics;

public class InterfaceVsAbstraction {

    /*
      1. Interface is a contract, and Abstract class is used to share common functionality.

      Abstract Class (extends):
      - Can have instance variables (fields that are not necessarily static or final).
      - Can have both abstract methods (without implementation) and concrete methods (with implementation).
      - Can have constructors.
     
      Interface (implements):
      - Can only have public static final (constant) fields.
      - Can have only abstract methods (before Java 8), but Java 8+ allows default and static methods.

      Interface can have abstract methods means:
      - All methods in an interface are implicitly public and abstract by default (except static and default methods in Java 8+).
      - You don't need to explicitly use the abstract keyword.
      - Any class that implements the interface must provide concrete implementations for all of its abstract methods.
    */

    interface Payment {
        void pay(double amount);  // Abstract method
    }
    
    class CreditCardPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
        }
    }
    
    class PayPalPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using PayPal.");
        }
    }

    abstract class Vehicle {
        int speed;
    
        Vehicle(int speed) {
            this.speed = speed;
        }
    
        abstract void start();  // Abstract method
    
        void stop() {  // Concrete method
            System.out.println("Vehicle stopped.");
        }
    }
    
    class Car extends Vehicle {
        Car(int speed) {
            super(speed);
        }
    
        @Override
        void start() {
            System.out.println("Car starts at speed: " + speed);
        }
    }

    public static void main(String[] args) {
        InterfaceVsAbstraction instance = new InterfaceVsAbstraction();

        Payment payment1 = instance.new CreditCardPayment();
        payment1.pay(100.50);
    
        Payment payment2 = instance.new PayPalPayment();
        payment2.pay(50.75);
        
        Car car = instance.new Car(100);
        car.start();
        car.stop();
    }
}