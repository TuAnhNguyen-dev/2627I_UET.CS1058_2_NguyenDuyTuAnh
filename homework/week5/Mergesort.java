package homework.week5;

public class Mergesort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = nums.length-1; i >= 0; i--) {
            nums[nums.length - i - 1] = i*i;
        }

        mergesort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] mergesort(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    private static void sort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(nums, left, mid);
        sort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int range = right - left + 1;
        int[] copyNums = new int[range];
        for (int i = 0; i < range; i++) {
            copyNums[i] = nums[left + i];
        }

        int i = 0, j = mid - left + 1;
        for (int idx = 0; idx < range; idx++) {
            int cur = -1;

            if (i == mid - left + 1) {
                cur = copyNums[j];
                j++;
            } else if (j == right - left + 1) {
                cur = copyNums[i];
                i++;
            } else if (copyNums[i] <= copyNums[j]) {
                cur = copyNums[i];
                i++;
            } else {
                cur = copyNums[j];
                j++;
            }

            nums[left + idx] = cur;
        }
    }
}
