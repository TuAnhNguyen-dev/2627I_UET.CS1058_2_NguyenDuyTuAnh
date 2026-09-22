package homework.week3;

import java.io.*;
import java.util.*;

public class SolutionForEx3 {

    public static class MyQueue<T> {
        private Stack<T> stackEnqueue = new Stack<>(), stackDequeue = new Stack<>();

        public void enqueue(T value){
            stackEnqueue.add(value);
        }

        public void dequeue() {
            prepareDequeue();
            stackDequeue.pop();
        }

        public T peek() {
            prepareDequeue();
            return stackDequeue.peek();
        }

        private void prepareDequeue() {
            if (stackDequeue.isEmpty()) {
                while (!stackEnqueue.isEmpty()) {
                    stackDequeue.add(stackEnqueue.pop());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < q; i++) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().isEmpty()) continue;

            String[] tokens = line.trim().split("\\s+");
            int type = Integer.parseInt(tokens[0]);

            if (type == 1) {
                int x = Integer.parseInt(tokens[1]);
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else if (type == 3) {
                bufferedWriter.write(queue.peek() + "\n");
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}