import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new Main().start();

    }

    int n, m, t, cur;
    int[] ans;

    private void start() {
        Scanner in = new Scanner(System.in);

        int cas;

        cas = 1;

        while (cas-- != 0) {
            n = in.nextInt();
            t = in.nextInt();
            m = in.nextInt();

            cur = 0;

            ans = new int[m];

            int curTime = 0;

            ArrayList<Integer> l, r;

            l = new ArrayList<Integer>();
            r = new ArrayList<Integer>();

            for (int i = 0; i < m; i++) {
                int time = in.nextInt();
                String left = in.next();

                if (left.equals("left")) {
                    l.add(time);
                    l.add(i);
                } else {
                    r.add(time);
                    r.add(i);
                }
            }

            while (l.size() != 0 || r.size() != 0) {
                int l1;

                if (l.size() > 0)
                    l1 = l.get(0);
                else
                    l1 = Integer.MAX_VALUE;
                int r1;

                if (r.size() > 0)
                    r1 = r.get(0);
                else
                    r1 = Integer.MAX_VALUE;

                int tn = n;

                if (cur == 0 && l1 <= curTime) {

                    while (tn-- != 0 && l.size() > 0 && l.get(0) <= curTime) {
                        l.remove(0);
                        ans[l.get(0)] = curTime + t;
                        l.remove(0);
                    }

                    curTime += t;
                    cur = 1;
                    continue;
                }

                if (cur == 1 && r1 <= curTime) {

                    while (tn-- != 0 && r.size() > 0 && r.get(0) <= curTime) {
                        r.remove(0);
                        ans[r.get(0)] = curTime + t;
                        r.remove(0);
                    }

                    curTime += t;
                    cur = 0;
                    continue;
                }

                if (l1 < r1) {// move left first

                    if (curTime < l1) {
                        curTime = l1;
                    }

                    if (cur == 1) {
                        cur = 0;
                        curTime += t;
                    }

                    while (tn-- != 0 && l.size() > 0 && l.get(0) <= curTime) {
                        l.remove(0);
                        ans[l.get(0)] = curTime + t;
                        l.remove(0);
                    }

                    curTime += t;
                    cur = 1;
                } else if (l1 > r1) {

                    if (curTime < r1) {
                        curTime = r1;
                    }

                    if (cur == 0) {
                        cur = 1;
                        curTime += t;
                    }

                    while (tn-- != 0 && r.size() > 0 && r.get(0) <= curTime) {
                        r.remove(0);
                        ans[r.get(0)] = curTime + t;
                        r.remove(0);
                    }

                    curTime += t;
                    cur = 0;
                } else {
                    if (curTime < r1) {
                        curTime = r1;
                    }
                    if (cur == 0) {

                        while (tn-- != 0 && l.size() > 0 && l.get(0) <= curTime) {
                            l.remove(0);
                            ans[l.get(0)] = curTime + t;
                            l.remove(0);
                        }

                        curTime += t;
                        cur = 1;
                    } else {
                        while (tn-- != 0 && r.size() > 0 && r.get(0) <= curTime) {
                            r.remove(0);
                            ans[r.get(0)] = curTime + t;
                            r.remove(0);
                        }

                        curTime += t;
                        cur = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                System.out.println(ans[i]);
            }
        }
    }
}
