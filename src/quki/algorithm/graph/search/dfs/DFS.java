
package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DFS {

    public static void dfs(int u, HashMap<Integer, ArrayList<Integer>> hm, boolean c[]) {
        c[u] = true;
        System.out.print(u+" ");
        for(int v: hm.get(u)){
            if(!c[v])
            dfs(v,hm,c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int vStart = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            hm.put(i, new ArrayList<Integer>());
        }
        while (M-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            hm.get(u).add(v);
            hm.get(v).add(u);
        }
        boolean c[] = new boolean[N+1]; // 현재 정점에 도달하면 true
        dfs(vStart, hm, c);
        System.out.println();
    }

}
