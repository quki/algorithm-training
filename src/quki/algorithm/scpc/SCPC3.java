package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SCPC3 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt(); // 최소 차수
			int L = sc.nextInt(); // 감염되어도 L개 이상 살아남아야한다
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
			for (int i = 0; i <= N; i++) {
				hm.put(i, new ArrayList<Integer>());
			}
			int degree[] = new int[N + 1];
			boolean isDeleted[] = new boolean[N + 1];
			while (M-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				hm.get(u).add(v);
				hm.get(v).add(u);
				degree[u]++;
				degree[v]++;
			}

			Queue<Integer> q = new LinkedList<>();
			int sum = 0;
			int remainVertex = N;

			while (true) {
				
				// 차수 K 미만인 Vertex 삭제
				for (int i = 1; i <= N; i++) {
					if (!isDeleted[i]) {
						if (degree[i] < K) {
							q.add(i);
							sum += i;
							isDeleted[i] = true;
							remainVertex--;
						}
					}
				}
				
				// 삭제 이후, 인접한 Vertex의 차수 update
				while (!q.isEmpty()) {
					int u = q.poll();
					
					for (int v : hm.get(u)) {
						if (!isDeleted[v]) {
							degree[v]--;
							if (degree[v] < K) {
								q.add(v);
								sum += v;
								isDeleted[v] = true;
								remainVertex--;
							}
						}
					}
				}
				
				// 감염시 L 미만 남게 되는 경우 삭제
				for (int i = 1; i <= N; i++) {
					if (!isDeleted[i]) {
						if (degree[i] > remainVertex - L - 1) {
							q.add(i);
							sum += i;
							isDeleted[i] = true;
							remainVertex--;
							break; // 최소값 하나만 찾아서 queue에 넣는다
						}
					}
				}

				if (q.isEmpty())
					break;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sum);

		}
	}

}
