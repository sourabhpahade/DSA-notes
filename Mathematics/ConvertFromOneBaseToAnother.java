package Mathematics;

import java.util.HashMap;

public class ConvertFromOneBaseToAnother {

    public String convertBase(String s, int a, int b) {

        HashMap<Character, Integer> m = new HashMap<>();
        m.put('A', 10);
        m.put('B', 11);
        m.put('C', 12);
        m.put('D', 13);
        m.put('E', 14);
        m.put('F', 15);

        // from base a to decimal
        int decimal = 0;
        int power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {

                decimal += m.get(s.charAt(i)) * power;

            } else {

                decimal += ((int) s.charAt(i) - 48) * power;

            }
            power = power * a;

        }

        String res = "";

        HashMap<Integer, Character> m1 = new HashMap<>();
        m1.put(10, 'A');
        m1.put(11, 'B');
        m1.put(12, 'C');
        m1.put(13, 'D');
        m1.put(14, 'E');
        m1.put(15, 'F');

        // from decimal to base b
        while (decimal > 0) {

            int temp = decimal % b;
            if (temp >= 10) {
                res = m1.get(temp) + res;
            } else {
                res = temp + res;
                decimal /= b;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
