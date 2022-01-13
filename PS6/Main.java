import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        // File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS6/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(file));
        String input = "";
        String st = br.readLine();
        int n = Integer.parseInt(st.split(" ")[0]);
        int m = Integer.parseInt(st.split(" ")[1]);
        int appointments = 0;
        Monk[] monks = new Monk[n];
        for (int i = 0; ((st = br.readLine()) != null); i++) {
            StringTokenizer sr = new StringTokenizer(st);
            int arrival = Integer.parseInt(sr.nextToken());
            int numVisits = Integer.parseInt(sr.nextToken());
            appointments += numVisits;
            Deque<Integer> d = new LinkedList<Integer>();
            for (int j = 0; j < numVisits; j++) {
                d.addLast(Integer.parseInt(sr.nextToken()));
            }
            monks[i] = new Monk(i, arrival, numVisits, d);
        }
        // System.out.println(Arrays.toString(monks));
        // int[] arr = Arrays.stream(br.readLine().split("
        // ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findTime1(monks, m, appointments));
    }

    public static int findTime1(Monk[] monks, int m, int appointments) {
        int completed = 0, time = 0;
        // for (Monk monk : monks) {
        // System.out.println(monk);
        // }
        ArrayList<Deque<Integer>> schedule = new ArrayList<Deque<Integer>>();
        for (int i = 0; i < m; i++) {
            schedule.add(new LinkedList<Integer>());
        }
        for (; completed < appointments; time++) {
            for (int i = 0; i < m; i++) {
                if (!schedule.get(i).isEmpty()) {
                    completed++;
                    monks[schedule.get(i).getFirst()].inQueue = false;
                    schedule.get(i).removeFirst();
                }
            }
            for (int i = 0; i < monks.length; i++) {
                if (monks[i].arrival <= time) {
                    if (!(monks[i].visits.size() == 0) && !monks[i].inQueue) {
                        schedule.get(monks[i].visits.getFirst() - 1).addLast(i);
                        monks[i].visits.removeFirst();
                        monks[i].inQueue = true;
                    }
                }
            }
            // System.out.println(schedule);
        }
        return time - 1;
    }

    // public static int findTime(Monk[] monks, int m) {
    // int time = 0;
    // ArrayList<Monk> monksList = new ArrayList<Monk>(Arrays.asList(monks));
    // ArrayList<ArrayList<Integer>> schedule = new ArrayList<ArrayList<Integer>>();
    // for (int i = 0; i < m; i++) {
    // schedule.add(new ArrayList<Integer>());
    // }
    // for (; !monksList.isEmpty(); time++) {
    // for (Monk monk : monks) {
    // if (!(monk.currOffice == monk.numVisits)) {
    // if (monk.arrival == time) {
    // schedule.get(monk.visits[0] - 1).add(monk.id);
    // monk.currOffice++;
    // } else {
    // if (monk.arrival < time) {
    // schedule.get(monk.visits[monk.currOffice] - 1).add(monk.id);
    // monk.currOffice++;
    // }
    // }
    // } else {
    // monksList.remove(monk);
    // }
    // }
    // for (int i = 0; i < m; i++) {
    // if (!(schedule.get(i).size() > time)) {
    // schedule.get(i).add(-1);
    // }
    // }
    // // System.out.println(schedule);
    // }
    // int max = Integer.MIN_VALUE;
    // for (ArrayList<Integer> office : schedule) {
    // if (office.size() > max) {
    // max = office.size();
    // }
    // }
    // // System.out.println(schedule.toString().replace("],", "],\n"));
    // return max + 1;
    // }
}

class Monk {
    public int id;
    public int arrival;
    public int numVisits;
    public Deque<Integer> visits;
    public int currOffice;
    public boolean inQueue;

    public Monk(int id, int arrival, int numVisits, Deque<Integer> visits) {
        this.arrival = arrival;
        this.id = id;
        this.numVisits = numVisits;
        this.visits = visits;
        this.currOffice = 0;
        this.inQueue = false;
    }

    public String toString() {
        return id + " " + arrival + " " + numVisits + " " + (visits.toString());
    }
}

// 5 3
// 1 3 3 2 1
// 0 7 2 3 1 1 1 1 2
// 2 1 1
// 1 2 3 3
// 4 3 1 1 1

// 5 10
// 3 1 6
// 2 3 3 2 8
// 2 1 4
// 2 4 7 9 9 6
// 0 2 8 7