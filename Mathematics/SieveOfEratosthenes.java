
package Mathematics;

import java.util.Arrays;

/**
 * sieveOfEratosthenes
 */
public class SieveOfEratosthenes {

    // => time complexity O(n*loglogn)

    public static void sieveOfEratosthenes(int n) {

        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, Boolean.TRUE);

        isprime[0] = isprime[1] = false;

        for (int i = 2; i <= n; i++) {

            if (isprime[i]) {
                
                System.out.println(i);

                for (int j = i * i; j <= n; j = j + i) {
                    isprime[j] = false;
                }
            }
        }
    }

}
