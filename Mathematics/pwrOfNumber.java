
//using bit 
package Mathematics;

/**
 * pwrOfNumber
 */
public class pwrOfNumber {

    // using bit
    public static int pwr1(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (((n & 1) == 1)) {
                res = res * x;
            }
            n = n >> 1;
            x = x * x;
        }
        return res;
    }

    // using recursion
    public static int pwr(int x, int n) {
        if (n == 0)
            return 1;

        int temp = pwr(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return x * temp;
        }
    }
}
