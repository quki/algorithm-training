package quki.algorithm.graph.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Queue와 depth를 생각
 * 
 * @author quki
 *
 */
public class BOJ1697 {

	public static final int MAX = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		boolean[] check = new boolean[MAX + 1];
		int[] depth = new int[MAX + 1];
		check[N] = true;
		depth[N] = 0;
		
		while (!q.isEmpty()) {
			int x = q.remove();

			if (x == K)
				break;

			if (x - 1 >= 0) {
				if (check[x - 1] == false) {
					q.add(x - 1);
					check[x - 1] = true;
					depth[x - 1] = depth[x] + 1;
				}
			}
			if (x + 1 <= MAX) {
				if (check[x + 1] == false) {
					q.add(x + 1);
					check[x + 1] = true;
					depth[x + 1] = depth[x] + 1;
				}
			}
			if (x * 2 <= MAX) {
				if (check[x * 2] == false) {
					q.add(x * 2);
					check[x * 2] = true;
					depth[x * 2] = depth[x] + 1;
				}
			}
		}
		System.out.println(depth[K]);
	}

}
