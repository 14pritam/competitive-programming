package Practice.Math;

public class LcmOfTwoNumber {

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 56, b = 98;
        System.out.println("LCM: " + lcm(a, b));
    }
}
