package homework.week3;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result2 {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    private static HashMap<Character, Integer> mp;

    public static String isBalanced(String s) {
        // Write your code here
        mp = new HashMap<>();
        mp.put('(', 1);
        mp.put(')', -1);
        mp.put('{', 2);
        mp.put('}', -2);
        mp.put('[', 3);
        mp.put(']', -3);

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int num = mp.get(s.charAt(i));
            if (!stk.empty() && num < 0 && stk.peek() + num == 0) {
                stk.pop();
            } else {
                stk.add(num);
            }
        }

        if (stk.isEmpty()) {
            return "YES";
        }

        return "NO";
    }

}

public class SolutionForEx2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result2.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
