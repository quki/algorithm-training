package quki.algorithm.bellman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 웜홀 문제 
 * Bellman-Ford로 음수 사이클이 있는지 확인하는 문제
 * 
 * @author quki
 *
 */
public class BOJ1865 {

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
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int w = sc.nextInt();
			ArrayList<Edge> edgeArr = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt(); // 걸리는 시간
				edgeArr.add(new Edge(u, v, c));
				edgeArr.add(new Edge(v, u, c));
			}
			for (int i = 0; i < w; i++) {
				int uW = sc.nextInt();
				int vW = sc.nextInt();
				int cW = sc.nextInt(); // 웜홀로 인해 줄어드는 시간
				edgeArr.add(new Edge(uW,vW,-cW));
			}
			int inf = 1000000000;
			int d[] = new int[n+1];
			Arrays.fill(d, inf);
			boolean isNegativeCycleExist = false;
			for (int i = 1; i <= n; i++) {
				for (Edge e : edgeArr) {
					int u = e.u;
					int v = e.v;
					int c = e.c;
					if(d[v] > d[u]+c){
						d[v] = d[u]+c;
						if(i == n)
							isNegativeCycleExist = true;
					}
				}
			}
			
			if(isNegativeCycleExist){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}

		}
	}

}
