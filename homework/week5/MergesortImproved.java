package homework.week5;

public class MergesortImproved {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[nums.length - i - 1] = i * i;
        }

        mergesort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] mergesort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // 1. Allocate auxiliary array only once at the beginning
        int[] aux = nums.clone();

        // 2. Call recursion: aux acts as source (src), nums acts as destination (dst)
        sort(aux, nums, 0, nums.length - 1);
        return nums;
    }

    // Ping-pong recursion: reads from src, merges into dst
    private static void sort(int[] src, int[] dst, int left, int right) {
        if (left >= right) {
            return; // At base case, dst already holds the correct element from initialization
        }

        int mid = left + (right - left) / 2;

        // SWAP ROLES: At the lower level, dst becomes the source, src becomes the destination.
        // The sorted sub-arrays will end up in src.
        sort(dst, src, left, mid);
        sort(dst, src, mid + 1, right);

        // Read two sorted halves from src and merge directly into dst
        merge(src, dst, left, mid, right);
    }

    private static void merge(int[] src, int[] dst, int left, int mid, int right) {
        int i = left;      // Pointer for the left half on src
        int j = mid + 1;  // Pointer for the right half on src

        // Merge directly from src to dst
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                dst[k] = src[j++];
            } else if (j > right) {
                dst[k] = src[i++];
            } else if (src[i] <= src[j]) {
                dst[k] = src[i++];
            } else {
                dst[k] = src[j++];
            }
        }
    }
}