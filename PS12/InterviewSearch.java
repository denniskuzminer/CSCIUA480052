import java.io.*;
import java.util.*;

public class InterviewSearch {
    public static void main(String args[]) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int n = Integer.parseInt(st);
        Interview[] interviews = new Interview[n];
        boolean[] isHourFilled = new boolean[48];
        HashMap<String, Integer> interviewsDone = new HashMap<String, Integer>();
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            interviews[i] = new Interview((st.split(" ")[0]), Integer.parseInt(st.split(" ")[1]),
                    Integer.parseInt(st.split(" ")[2]), Integer.parseInt(st.split(" ")[3]));
            interviewsDone.put(st.split(" ")[0], 0);
            Arrays.fill(isHourFilled, Integer.parseInt(st.split(" ")[1]), Integer.parseInt(st.split(" ")[2]), true);
        }
        System.out.println(getMaxTime(0, 0, 0, interviews, interviewsDone, isHourFilled, ""));
    }

    public static int getMaxTime(int currTime, int timeSpent, int i, Interview[] interviews,
            HashMap<String, Integer> interviewsDone, boolean[] isHourFilled, String str) {
        if (currTime > 47) {
            return timeSpent;
        }
        if (i == interviews.length) {
            // System.out.println(s tr + " " + currTime);
            System.out.println(currTime + " " + str);
            return timeSpent;
        }
        // if (interviews[i].start < currTime && isHourFilled[currTime]) {
        // System.out.println(currTime + " " + str);
        // return getMaxTime(currTime, timeSpent, i + 1, interviews, interviewsDone,
        // isHourFilled, str);
        // // System.out.println(currTime + " " + str);
        // // return timeSpent;
        // }

        // if (canProceed(interviews[i], interviewsDone)) {
        return Math.max(
                getMaxTime(interviews[i].end, timeSpent + (interviews[i].end - interviews[i].start), i + 1, interviews,
                        interviewsDone, isHourFilled, str + interviews[i]),
                getMaxTime(interviews[i].end, timeSpent, i + 1, interviews, interviewsDone, isHourFilled, str));
        // }
        // return getMaxTime(interviews[i].end, timeSpent, i + 1, interviews,
        // interviewsDone, 0, isHourFilled, str);
    }

    static boolean canProceed(Interview interview, HashMap<String, Integer> interviewsDone) {
        return interviewsDone.get(interview.name) + 1 == interview.level;
    }
}

class Interview {
    String name;
    int start, end, level;

    public Interview(String name, int start, int end, int level) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Start: " + start + " End: " + end + " Level: " + level;
    }
}