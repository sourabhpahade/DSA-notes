package Recursion;

/**
 * PermutationOfString
 */
public class PermutationOfString {

    // Q) generating all permutaion of string.

    // => O(n!)

    // Explanation : Idea is to fix first letter recursively and then find
    // combination of next letter.

    public static void printAllPermutation(String str, int i) {

        if (i == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            printAllPermutation(str, i + 1);
            str = swap(str, j, i);
        }

    }

    // swaping letters of string using char array

    static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        str = String.valueOf(ch);
        return str;
    }

}
