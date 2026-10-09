import java.io.*;
import java.util.*;

public class SolutionEx4 {
    public static void main(String[] args) throws IOException{
        solutionUsingClass();
    }

    public static void solutionUsingClass() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int id = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            double cgpa = Double.parseDouble(st.nextToken());

            Student student = new Student(id, name, cgpa);
            students.add(student);
        }

        br.close();

//        comparator has three possible outcome. -1 means o1 then o2. 1 means o2 then o1. 0 means tie
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                decreasing means that we reverse input
                if (o1.cgpa != o2.cgpa) {
                    return Double.compare(o2.cgpa, o1.cgpa);
                }

                int nameCompare = o1.name.compareTo(o2.name);
                if (nameCompare != 0) {
                    return nameCompare;
                }

                return Integer.compare(o1.id, o2.id);
            }
        });

        for (Student s: students) {
            System.out.println(s.name);
        }
    }
}

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}
