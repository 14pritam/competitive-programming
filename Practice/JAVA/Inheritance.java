package Practice.JAVA;

public class Inheritance {
    interface A {
        default void m1() {
            System.out.println("AAA");
        }
    }

    interface B {
        default void m1() {
            System.out.println("BBB");
        }
    }

    public static class C implements A, B {
        public static void main(String[] args) {
            C c = new C();
            c.callA(); // Output: AAA
            c.callB(); // Output: BBB
        }

        public void callA() {
        A.super.m1();
        }

        public void callB() {
            B.super.m1(); // Calls B's m1
        }

        @Override
        public void m1() {
            // Optional override
        }
    }
}