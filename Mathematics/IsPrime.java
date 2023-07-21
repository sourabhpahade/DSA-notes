
package Mathematics;

/**
 * IsPrime
 */
public class IsPrime {

  // logic : if any prime no. n divides p i.e n*n<=p then p is not prime.
  // => time Complexity O(root n);

  public static boolean isPrime(int n) {

    if (n <= 1)
      return false;

    if (n == 2 || n == 3)
      return true;

    if (n % 2 == 0 || n % 3 == 0)
      return false;

    for (int i = 5; i * i <= n; i = i + 6) {
      if (n % i == 0)
        return false;
      if (n % (i + 2) == 0)
        return false;
    }

    return true;
  }
}
