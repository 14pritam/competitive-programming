package Practice.Array;

public class Animal {

    abstract class Animal1 {
        abstract void sound(); // Abstract method
    }

    abstract class Dog extends Animal1 {
        // No need to override sound() because Dog is also abstract
    }

    class Puppy extends Dog {

        @Override
        void sound() {

        }
    }
}
