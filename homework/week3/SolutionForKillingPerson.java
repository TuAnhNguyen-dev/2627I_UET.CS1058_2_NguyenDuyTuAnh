package homework.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionForKillingPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();

            while (q > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                System.out.println(n);

                BrutalForce sol1 = new BrutalForce();
                System.out.println(sol1.brutalForce(n, k));

                OptimalSolution sol2 = new OptimalSolution();
                System.out.println(sol2.optimalSolution(n, k));

                System.out.println();

                q--;
            }
        }

        scanner.close();
    }
}

class BrutalForce {
    public int brutalForce(int n, int k) {
        List<Integer> persons = new ArrayList<Integer>();
        int currStart = 0;

        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }

        while (n > 1) {
            int nextIndex = (currStart + k - 1) % n;
            persons.remove(nextIndex);
            n--;
            currStart = nextIndex % n;
        }

        return persons.get(0);
    }
}

class OptimalSolution {
    public int optimalSolution(int n, int k) {
        int survivorIndex = 0;

        for (int i = 2; i <= n; i++) {
            survivorIndex = (survivorIndex + k) % i;
        }

        return survivorIndex + 1;
    }
}