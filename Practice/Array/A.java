package Practice.Array;

public class A {
    static class Ab {
        public Ab() {
            System.out.println("Parent Class Ab");
        }
    }

    static class B extends Ab {
        public B() {
            System.out.println("Parent Class B");
        }
    }

    static class C extends B {
        public C() {
            System.out.println("Child Class C");
        }
    }

    public static void main(String[] args) {
        C c = new C();
    }
}