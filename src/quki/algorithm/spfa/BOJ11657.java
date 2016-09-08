package quki.algorithm.spfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Shortest Path Faster Algorithm(SPFA)
 * 로 타임머신 문제 풀기
 *
 * @author quki
 *
 */
public class BOJ11657 {

	public static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			hm.put(i, new ArrayList<Edge>());
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			hm.get(u).add(new Edge(v, c));
		}
		int d[] = new int[n + 1];
		int inf = 1000000000;
		Arrays.fill(d, inf);
		d[1] = 0;

		// Queue에 현재 있으면 check
		boolean isExistInQueue[] = new boolean[n + 1];

		// update되는 횟수 count
		int cycle[] = new int[n + 1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while (!q.isEmpty()) {
			int u = q.poll();
			isExistInQueue[u] = false;

			for (Edge e : hm.get(u)) {
				int v = e.v;
				int c = e.c;
				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
					if (!isExistInQueue[v]) {
						q.add(v);
						isExistInQueue[v] = true;
						cycle[v]++;
						
						// update가 되는 횟수가 n을 넘으면 cycle이 있다는 뜻
						if(cycle[v] >=n){
							System.out.println(-1);
							return;
						}
					}
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (d[i] == inf) {
				System.out.println(-1);
			} else {
				System.out.println(d[i]);
			}

		}

	}

}
