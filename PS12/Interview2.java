import java.io.*;
import java.util.*;

public class Interview2 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/denni/Comp Sci/CSCIUA480052/PS12/input.txt");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int n = Integer.parseInt(st);
        HashMap<String, Integer> M = new HashMap<String, Integer>();

        List<PriorityQueue<List<Integer>>> V = new ArrayList<PriorityQueue<List<Integer>>>();

        int idx = 1;
        for (int i = 1; ((st = br.readLine()) != null); i++) {
            String name = st.split(" ")[0];
            if (M.get(name) == null) {
                M.put(name, idx);
                idx++;
            }
            int start = Integer.parseInt(st.split(" ")[1]);
            int end = Integer.parseInt(st.split(" ")[2]);
            int round = Integer.parseInt(st.split(" ")[3]);
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(round * -1);
            temp.add(start);
            temp.add(end);
            // if (V.get(M.get(name)) == null) {
            V.add(M.get(name), new PriorityQueue<List<Integer>>());
            // }
            V.get(M.get(name)).add(temp);
        }
        solve(V, 0, 0, idx);

    }

    static int solve(List<PriorityQueue<List<Integer>>> V, int t, int time, int idx) {
        // cout<<idx;
        if (time > 48)
            return t;

        int best = -1;
        for (int i = 1; i < idx; i++) {
            if (V.get(i).isEmpty())
                continue;
            if (V.get(i).peek().get(1) == time) {
                List<PriorityQueue<List<Integer>>> temp = V;
                temp.get(i).poll();
                best = Math.max(
                        solve(temp, t + V.get(i).peek().get(2) - V.get(i).peek().get(1), V.get(i).peek().get(2), idx),
                        best);

            }
        }
        best = Math.max(best, solve(V, t, time + 1, idx));

        return best;
    }

}

// int solve(vector<priority_queue<vector<int> > >& V, int t, int time, int
// idx){
// //cout<<idx;
// if(time > 48) return t;

// int best = -1;
// for(int i = 1; i < idx; i++){
// if(V[i].empty()) continue;
// if(V[i].top()[1] == time){
// vector<priority_queue<vector<int> > > temp = V;
// temp[i].pop();
// best = max(solve(temp,t+V[i].top()[2] - V[i].top()[1], V[i].top()[2],idx),
// best);

// }
// }
// best = max(best, solve(V, t,time+1,idx));

// return best;
// }
