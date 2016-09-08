package quki.algorithm.graph.search.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 모든 시작점에 대해 BFS로 푸는 문제
 * 
 * @author quki
 *
 */
public class BOJ1389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			hm.put(i, new ArrayList<Integer>());
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			hm.get(u).add(v);
			hm.get(v).add(u);
		}
		
		int d[] = new int[n+1];
		
		// 모든 시작점에 대해서 검사
		for (int k = 1; k <= n; k++) {
			int start = k;
			boolean check[] = new boolean[n+1];
			int depth[] = new int[n+1];
			check[start] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			while(!q.isEmpty()){
				int u = q.poll();
				for(int v : hm.get(u)){
					if(!check[v]){
						q.add(v);
						check[v] = true;
						depth[v] = depth[u]+1;
					}
				}
			}
			
			int sum = 0;
			for(int i = 1; i<=n;i++){
				sum+=depth[i];
			}
			d[start] = sum;
		}
		int inf = 1000000000;
		int ans = 0;
		int min = inf;
		for(int i = 1; i<=n;i++){
			if(d[i] < min){
				ans = i;
				min = d[i];
			}
		}
		
		System.out.println(ans);

	}

}
