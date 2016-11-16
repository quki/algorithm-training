package quki.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * LCA
 * 공통 조상 찾기
 * 
 */
public class BOJ11437 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
		for (int i = 0; i <= N; i++) {
			tree.put(i, new ArrayList<Integer>());
		}
		int depth[] = new int[N + 1];
		boolean check[] = new boolean[N + 1];
		int parent[] = new int[N + 1];
		for (int i = 1; i <= N - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		// tree 생성
		int root = 1;
		depth[root] = 0;
		check[root] = true;
		parent[root] = root;
		Queue<Integer> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : tree.get(x)) {
				if (!check[y]) {
					depth[y] = depth[x] + 1;
					q.add(y);
					check[y] = true;
					parent[y] = x;
				}

			}
		}

		int M = sc.nextInt();
		while (M-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// depth가 x가 y보다 작았으면 한다.
			if (depth[x] > depth[y]) {
				int temp = x;
				x = y;
				y = temp;
			}
			while (depth[x] != depth[y]) {
				y = parent[y];
			}

			while (x != y) {
				x = parent[x];
				y = parent[y];
			}
			System.out.println(x);
		}

	}

}
