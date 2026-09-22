package homework.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionForKillingPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            BrutalForce sol1 = new BrutalForce();
            System.out.println(sol1.brutalForce(n, k));
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

class UnionFind {
    private int[] parents, weighted;

    public int unionFind(int n, int k) {
        parents = new int[n];
        weighted = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            weighted[i] = 1;
        }

        int currPersonLeft = n;
        while (currPersonLeft > 1) {

        }

        return findRoot(0);
    }

    private int findRoot(int p) {
        while (parents[p] != p) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pRoot = findRoot(p), qRoot = findRoot(q);

        // make sure pRoot always point to qRoot
        if (weighted[pRoot] > weighted[qRoot]) {
            int temp = pRoot;
            pRoot = qRoot;
            qRoot = temp;
        }

        parents[pRoot] = qRoot;
        weighted[qRoot] += weighted[pRoot];
    }
}