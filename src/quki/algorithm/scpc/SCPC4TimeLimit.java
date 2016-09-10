package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * SCPC 4
 * 대피소 문제, SPFA로 풀었지만 시간초과가 발생하는 코드
 * 
 * @author quki
 *
 */
public class SCPC4TimeLimit {

	public static class Edge {
		int v;
		int c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int d[][] = new int[N + 1][2]; // 0: 최단거리, 1: 가장가까운 대피소

			HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
			for (int i = 0; i <= N; i++) {
				hm.put(i, new ArrayList<Edge>());
			}
			while (M-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				hm.get(u).add(new Edge(v, c));
				hm.get(v).add(new Edge(u, c));
			}

			ArrayList<Integer> pArray = new ArrayList<>();
			boolean isP[] = new boolean[N + 1]; // 대피소 입니까?
			while (K-- > 0) {
				int p = sc.nextInt();
				pArray.add(p);
				d[p][1] = p;
				isP[p] = true;
			}

			// 각 대피소를 시작점으로
			for (int pStart : pArray) {

				Queue<Integer> q = new LinkedList<Integer>();
				q.add(pStart);
				boolean isInQueue[] = new boolean[N + 1];
				isInQueue[pStart] = true;

				while (!q.isEmpty()) {
					int u = q.poll();
					isInQueue[u] = false;

					for (Edge edge : hm.get(u)) {
						int v = edge.v;
						int c = edge.c;

						if (!isP[v]) {

							if (d[v][0] > d[u][0] + c || d[v][0] == 0) {
								d[v][0] = d[u][0] + c;
								d[v][1] = pStart;
								if (!isInQueue[v]) {
									q.add(v);
									isInQueue[v] = true;
								}
							}
						}

					}

				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			int ans1 = 0;
			int ans2 = 0;
			for (int i = 1; i <= N; i++) {
				ans1 += d[i][0];
			}
			for (int i = 1; i <= N; i++) {
				ans2 += d[i][1];
			}
			System.out.println(ans1 + "\n" + ans2);
		}
	}

}
