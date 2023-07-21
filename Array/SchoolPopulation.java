package Array;

public class SchoolPopulation {

    public int[] population(int[] nums) {

        if (nums[nums.length - 1] < 9) {
            nums[nums.length - 1] += 1;
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == 9) {
                nums[i] = 0;
            } else {
                nums[i] += 1;
                return nums;
            }
        }

        int[] result = new int[nums.length + 1];

        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {

    }
}
