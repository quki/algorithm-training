
package quki.algorithm.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BOJ #1149 Using BFS
 * 
 * @author quki
 */
public class P1149BFS {

    public static class Point {
        int i;

        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        int[][] s = new int[n][3]; // 해당 index까지의 sum의 최소값
        int inf = 1000000000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int e = sc.nextInt();
                ;
                a[i][j] = e;
                if (i == 0) {
                    s[i][j] = e;
                } else {
                    s[i][j] = inf;
                }

            }
        }
        // BFS
        Queue<Point> q = new LinkedList<>();
        int i = 0;
        int min = inf;
        for (int j = 0; j < 3; j++) {
            q.add(new Point(i, j));
            while (!q.isEmpty()) {
                Point p = q.poll();
                int newI = p.i + 1; // 한 줄 아래 row
                for (int k = 0; k < 3; k++) {
                    int newJ = k; // k -> 0,1,2
                    if (newI <= n - 1 && p.j != newJ) {  // 바로 아래칸 제외 (같은 column)
                        q.add(new Point(newI, newJ));
                        if (s[newI][newJ] > s[newI - 1][p.j] + a[newI][newJ]) {
                            s[newI][newJ] = s[newI - 1][p.j] + a[newI][newJ]; // 최소값으로 초기화
                            if (newI == n - 1) { // 맨 아래 row
                                min = Math.min(s[newI][newJ], min);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

}
