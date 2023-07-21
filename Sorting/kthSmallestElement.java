package Sorting;

class Solution {

    // Function to find the kth smallest element in the array.
    public static int kthSmallest(int arr[], int n, int k) {
        return sol(arr, 0, n - 1, k);
    }

    static int sol(int[] arr, int low, int high, int k) {
        // generating pivot
        int p = lomuto(arr, low, high);

        // if p==k-1 means we have found the kth smallest
        if (p == k - 1) {
            return arr[p];
        }

        // if p>k-1 means kth smallest is present at left of p => high= p-1
        if (p > k - 1) {
            return sol(arr, low, p - 1, k);
        } else {
            // kth smallest is at right of p => low=p+1
            return sol(arr, p + 1, high, k);
        }

    }

    static int lomuto(int[] arr, int low, int high) {

        // genrating random pivot index in range(low,high)
        int p = (int) (Math.random() * (high - low + 1)) + low;

        int i = low - 1;

        // Swapping the pivot to last element
        int temp = arr[p];
        arr[p] = arr[high];
        arr[high] = temp;

        // after swapping pivot is at high
        int pivot = arr[high];

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swapping pivot at its rigth position after segregating array
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // returning right position of pivot
        return i + 1;

    }

}

// Better Code.

class Solution2 {

    static int partition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;
    }

    static int kthSmallest(int arr[], int n, int k) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = partition(arr, l, r);
            if (p == k - 1)
                return p;
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }
}
