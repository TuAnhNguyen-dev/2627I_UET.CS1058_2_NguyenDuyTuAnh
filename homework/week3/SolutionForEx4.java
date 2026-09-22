package homework.week3;

import java.io.*;
import java.util.*;

public class SolutionForEx4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().isEmpty()) continue;

            String[] tokens = line.trim().split("\\s+");
            int type = Integer.parseInt(tokens[0]);

            switch (type) {
                case 1:
                    history.push(s.toString());
                    String w = tokens[1];
                    s.append(w);
                    break;

                case 2:
                    history.push(s.toString());
                    int k = Integer.parseInt(tokens[1]);
                    s.delete(s.length() - k, s.length());
                    break;

                case 3:
                    int index = Integer.parseInt(tokens[1]) - 1;
                    bufferedWriter.write(s.charAt(index) + "\n");
                    break;

                case 4:
                    if (!history.isEmpty()) {
                        s = new StringBuilder(history.pop());
                    }
                    break;
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}