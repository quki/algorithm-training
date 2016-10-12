package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ1707 {

	static void setColor(int start, int color, int[] colorArray,HashMap<Integer, ArrayList<Integer>> graph) {
		colorArray[start] = color;
		for(int next: graph.get(start)){
			if(colorArray[next] == 0){
				setColor(next, -color, colorArray, graph);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
			int colorArray[] = new int[V + 1];
			

			for (int i = 1; i <= V; i++) {
				graph.put(i, new ArrayList<Integer>());
			}
			while (E-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			for (int start = 1; start <= V; start++) {
				if (colorArray[start] != 0)
					continue;
				setColor(start, 1, colorArray, graph);
			}
			
			boolean isBipartite = true;
			for (int u = 1; u <= V; u++) {
                for( int v: graph.get(u)){
                    if(colorArray[u] == colorArray[v]){
                        isBipartite = false;
                    }
                }
            }
			

			if (isBipartite) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}
