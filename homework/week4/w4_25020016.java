package homework.week4;

import java.util.Arrays;
import java.util.Scanner;

public class w4_25020016 {
    public int SortSolution(int n, int[] arr) {
        Arrays.sort(arr);

        int ans = 0;

        while (ans < n && arr[n - ans - 1] > ans) {
            ans += 1;
        }

        return ans;
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println(SortSolution(n, nums));
        }

        scanner.close();
    }
}
