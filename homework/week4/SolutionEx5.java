import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultEx5 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < n; i++) {
            insertNumber(i, arr);
            printArr(arr);
        }
    }

    public static void insertNumber(int idx, List<Integer> arr) {
        int n = arr.size();
        int target = arr.get(idx);
        idx -= 1;

        while (idx >= 0 && arr.get(idx) > target) {
            arr.set(idx+1, arr.get(idx));
            idx--;
        }

        arr.set(idx + 1, target);
    }

    private static void printArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print('\n');
    }

}

public class SolutionEx5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultEx5.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
