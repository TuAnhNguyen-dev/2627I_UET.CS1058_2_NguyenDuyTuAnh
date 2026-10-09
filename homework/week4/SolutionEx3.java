import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultEx3 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int target = arr.get(n-1);
        int insertIndex = n-2;

        while (insertIndex >= 0 && arr.get(insertIndex) > target) {
            arr.set(insertIndex+1, arr.get(insertIndex));
            insertIndex--;
            printArr(arr);
        }

        arr.set(insertIndex + 1, target);
        printArr(arr);
    }

    private static void printArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print('\n');
    }

}

public class SolutionEx3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultEx3.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
