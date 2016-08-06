
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1937 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    /**
     * @return d[i][j]: 해당 지점에 도달하는 데 최대 경로 수.
     */
    public static int go(int a[][], int d[][], int i, int j) {

        int n = a[0].length - 1;

        if (d[i][j] != 0) 
            return d[i][j];
        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 1 && newI <= n && newJ >= 1 && newJ <= n) {
                if (a[i][j] > a[newI][newJ]) {
                    int t2 = go(a, d, newI, newJ) + 1; // depth 1증가(현재 위치)
                    d[i][j] = Math.max(d[i][j], t2);
                }
            }
        }
        
        // 더 이상 갈 곳이 없는 지점(말단)에서 return을 하는데
        // 이때, 현재 위치의 값이 0인 경우(해당 지점에 처음 온 경우)에는 1로 만들어 return 한다.
        if (d[i][j] == 0) 
            return d[i][j] = 1;
        
        return d[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n + 1][n + 1];
        int d[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        //d[i][j]: 해당 지점에 도달하는 데 최대 경로 수.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == 0)
                    max = Math.max(max, go(a, d, i, j));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append("\n");
            for (int j = 1; j <= n; j++) {
                sb.append(d[i][j] + " ");
            }
        }
        System.out.println(sb);
        System.out.println(max);
    }
}
