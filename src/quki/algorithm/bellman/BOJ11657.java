package quki.algorithm.bellman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 타임머신 문제 Bellman Ford
 * 
 * 시간복잡도: VE, 그러나 E<=V^2 이기 때문에 일반적으로 V^3
 * 
 * @author quki
 *
 */
public class BOJ11657 {

	public static class Edge {
		int u;
		int v;
		int c;

		Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[] = new int[n + 1];
		Edge edgeArr[] = new Edge[m + 1]; // Edge의 갯수만큼 초기화

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			edgeArr[i] = new Edge(a, b, c);
		}
		int inf = 1000000000;
		Arrays.fill(d, inf);
		d[1] = 0;
		boolean isNegativeCycleExist = false;
		// V만큼 for문 돌림, 음수 간선이 없다면 V-1만큼 돌려도 되지만,
		// 음수 cycle이 있는 경우 마지막 V번째에 update가 이뤄지므로 V번까지 돌려야한다.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				Edge e = edgeArr[j]; // 모든 Edge를 검사
				int u = e.u;
				int v = e.v;
				int c = e.c;

				// Relaxation
				if (d[v] > d[u] + c) {
					d[v] = d[u] + c;
					if (i == n)
						isNegativeCycleExist = true;
				}

			}
		}

		if (isNegativeCycleExist) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				if(d[i] == inf){
					System.out.println(-1);
				}else{
					System.out.println(d[i]);
				}
			}
		}

	}

}
