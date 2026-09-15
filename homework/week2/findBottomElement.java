package homework.week2;

import java.util.Scanner;

public class findBottomElement {
    public int findBottomElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1; // Return -1 for empty array
        }

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            findBottomElement solution = new findBottomElement();
            int result = solution.findBottomElement(nums);
            System.out.println(result);
        }

        scanner.close();
    }
}
