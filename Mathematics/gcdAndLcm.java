package Mathematics;

/**
 * gcdAndLcm
 */
public class gcdAndLcm {

    // logic:By Euclid'stheorem.gcd(a,b)=gcd(a,a-b)
    // i.e a>b;
    // lcm(a,b) * gcd(a,b) = a*b;

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gcd2(int a, int b) {

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
