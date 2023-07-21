package Array;

public class SplitArrayIntoThreeEqualParts {

    public boolean canThreePartsEqualSum(int[] arr) {

        int total = 0;

        for (int val : arr) {
            total += val;
        }

        if (total % 3 != 0)
            return false;

        int equalSum = total / 3;

        int totalParts = 0;

        total = 0;

        for (int index = 0; index < arr.length; index++) {

            total += arr[index];

            if (total == equalSum && totalParts <= 2) {
                totalParts++;
                total = 0;
            }

        }

        return totalParts == 3;

    }
}
