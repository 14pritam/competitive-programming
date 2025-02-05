package Practice.Math;

// GCD (Greatest Common Divisor) also called HCF (Highest Common Factor)
public class GcdOfTwoNumber {

    // GCD using Euclidean Algorithm
    public static void main(String[] args) {
        int a = 56, b = 98;
        System.out.println("GCD: " + gcd(a, b));
    }


    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
