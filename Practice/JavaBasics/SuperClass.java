package Practice.JavaBasics;


public class SuperClass {
   /* 1. In Java, a constructor should not have a return type (not even void).   
      2. No, we cannot use the super keyword in a static method.
      3. They belong to the class itself, not to any specific object. You can call them 
         directly using the class name without creating an object.
      4. No, super cannot access private members of the parent class directly. 
         Only protected, public, and default (within the same package) members can be accessed.
      5. What happens if the parent class doesn’t have a no-argument constructor and the child class calls super() implicitly?
         The code will fail to compile because the compiler will insert super(), but there is no no-argument constructor in 
         the parent class.
      6. Can super() and this() be used in the same constructor? 
         No, both must be the first statement in a constructor. Using both together will cause a compile-time error.
   */
       public class ParentClass {
           public ParentClass() {
               System.out.println("Parent Class");
           }
   
           public void display() {
               System.out.println("Display method in Parent Class");
           }
       }
   
       public class ChildClass extends ParentClass {
           public ChildClass() {
               System.out.println("Child Class");
           }
   
           @Override
           public void display() {
            super.display();
               System.out.println("Display method in Child Class");
           }
       }
   
       public static void main(String[] args) {
        // The Parent Class Constructor should be executed first then childClass Constructor.

           SuperClass outer = new SuperClass();
           ChildClass c = outer.new ChildClass();  // Creating instance of inner class
           c.display();
       }
   }