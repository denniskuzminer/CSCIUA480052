import java.io.*;
import java.util.*;

class AyuCourse {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
        Scanner br = new Scanner(new InputStreamReader(System.in));
        // Scanner br = new Scanner(new FileReader(file));
        int S = br.nextInt();
        int N = br.nextInt();
        ArrayList<Course> courses = new ArrayList<Course>();
        for (int i = 1; i <= N; i++) {
            Course course = new Course(i);
            int len = br.nextInt();
            for (int j = 0; j < len; j++) {
                course.prereqs.add(br.nextInt());
            }
            courses.add(course);
        }
        for (int sem = 0; courses.size() > 0; sem++) {
            String ans = "";
            ans += ("Sem" + (sem + 1) + ": ");
            int countNoPrereqs = 0;
            for (Course course : courses)
                if (course.prereqs.size() == 0)
                    countNoPrereqs++;
            Collections.sort(courses, Comparator.comparing(Course::getPrereqsSize).thenComparing(Course::getI));
            for (int i = 0; i < S; i++) {
                if (i < countNoPrereqs) {
                    if (courses.size() > 0 && courses.get(0).prereqs.size() == 0) {
                        // delete courses.get(0).i; from every course.prereq
                        courses.forEach(course -> course.prereqs.remove(new Integer(courses.get(0).i)));
                        ans += (courses.get(0).i + " ");
                        // pop
                        courses.remove(0);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(ans.trim());
        }
    }
}

class Course {
    int i;
    ArrayList<Integer> prereqs;

    public Course(int i) {
        this.i = i;
        prereqs = new ArrayList<Integer>();
    }

    public int getI() {
        return i;
    }

    public int getPrereqsSize() {
        return prereqs.size();
    }

    @Override
    public String toString() {
        return i + " " + prereqs.toString();
    }
}