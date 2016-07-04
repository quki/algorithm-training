
package quki.algorithm.graph.search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    public static class Point {
        int x;

        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int inf = 1000000000;
        int a[][] = new int[n + 1][m + 1];
        int d[][] = new int[n + 1][m + 1];
        boolean c[][] = new boolean[n + 1][m + 1];
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                    a[i][j] = Integer.parseInt(""+line.charAt(j-1));
                    d[i][j] = inf;
            }
        }

        // a[1][1] 에서 출발
        d[1][1] = 1;
        c[1][1] = true;
        int dx[] = {
                1, 0, 0, -1
        };
        int dy[] = {
                0, 1, -1, 0
        };
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(1, 1));
        while (!q.isEmpty()) {
            // for (int k = 0; k < q.size(); k++) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int h = 0; h < dx.length; h++) {
                int newX = x + dx[h];
                int newY = y + dy[h];
                if (newX >= 1 && newX <= m && newY >= 1 && newY <= n) {
                    if(!c[newY][newX]&& a[newY][newX] != 0){
                        q.add(new Point(newX, newY));
                        c[newY][newX] = true;
                        d[newY][newX] = Math.min(d[y][x] + 1, d[newY][newX]);
                    }
                }
            }
        }
       
        System.out.println(d[n][m]);
    }
}
