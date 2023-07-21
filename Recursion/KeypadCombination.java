package Recursion;

public class KeypadCombination {

    // mapping keys by storing in array
    static String[] keys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    static void printKPC(String ques) {

        print(ques, "", 0);
    }

    // generating combinations
    static void print(String str, String ssf, int i) {

        if (i == str.length()) {
            System.out.println(ssf);
            return;
        }

        // getting key pressed
        int idx = ((int) str.charAt(i)) - 48;

        // we generate permutation key wise recursively
        for (int j = 0; j < keys[idx].length(); j++) {
            print(str, ssf + keys[idx].charAt(j), i + 1);
        }
    }

}
