package Array;

public class freqInLimitedRange {

    public static void frequencyCount(int arr[], int N, int P) {
        // code here

        int i = 0;

        while (i < N) {

            if (arr[i] > N) {
                arr[i] = 0;
                i++;
                continue;
            }
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            int idx = arr[i] - 1;

            if (arr[idx] > 0) {

                arr[i] = arr[idx];
                arr[idx] = -1;
            } else {
                arr[idx]--;
                arr[i] = 0;
                i++;
            }

        }

        for (int j = 0; j < N; j++) {
            arr[j] = -arr[j];
        }

    }
}
