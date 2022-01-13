import java.io.*;
import java.util.*;

class CodeChef {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        String st;
        for (int i = 0; (i < cases) && ((st = br.readLine()) != null); i++)
            System.out.println(((Integer.parseInt(st.split(" ")[1]) + Integer.parseInt(st.split(" ")[0])) > Integer
                    .parseInt(st.split(" ")[2])) ? "NO" : "YES");
    }
}
// https://www.codechef.com/START17C/problems/CHEFVACATION
// https://www.codechef.com/viewsolution/53938259