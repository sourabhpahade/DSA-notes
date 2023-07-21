package Recursion;

public class RecursiveRemoveDuplicates {

    static String solve(String s) {

        StringBuilder temp = new StringBuilder(s);
        StringBuilder res = new StringBuilder("");

        while (true) {

            boolean flag = true;
            int start = 0;
            int end = 1;
            int n = temp.length();

            while (end < n) {

                if (temp.charAt(start) == temp.charAt(end)) {

                    flag = false;
                    end++;

                } else {

                    if (end > start + 1) {

                        start = end;
                        if (end < n - 1) {
                            end++;
                        }

                    } else {

                        res.append(temp.charAt(start));

                        if ((end == n - 1) && (temp.charAt(end) != temp.charAt(end - 1))) {

                            res.append(temp.charAt(end));

                        }
                        // System.out.println(res);
                        start++;
                        end++;

                    }
                }
            }

            if (!flag) {

                System.out.println(res);
                temp.setLength(0);
                temp.append(res);
                res.setLength(0);

            } else {
                break;
            }

        }
        // System.out.println(temp);

        return temp.toString();

    }

    public static void main(String[] args) {

        System.out.println(solve("aaaacddddcappp"));
    }
}
