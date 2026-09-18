package homework.week2;

import java.util.Scanner;

public class findBottomElement {
    public int findBottomElement(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return n-1;
        }

        if (nums[n-1] < nums[n-2]) {
            return n-1;
        }

        int left = 0;
        int right = n - 2;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] < nums[mid+1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
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
