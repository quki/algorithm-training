
package quki.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ1495Fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);
        String aline[] = br.readLine().split(" ");
        int a[] = new int[n + 1];
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(aline[i - 1]);
            hm.put(i, new ArrayList<Integer>());
        }
        hm.put(0, new ArrayList<Integer>());
        hm.get(0).add(s);
        
        int dx[] = {-1,1};
        for (int i = 1; i <= n; i++) {
            for (int x : hm.get(i - 1)) {
                for(int k = 0; k<2;k++){
                    int nx = x+dx[k]*a[i];
                    if (nx >= 0 && nx <= m) {
                        hm.get(i).add(nx);
                    }
                }
            }
        }
        int max = 0;
        for (int i : hm.get(n)) {
           max = Math.max(max, i);
        }
        int ans = max == 0 ? -1 : max;
        System.out.println(ans);

    }

}
