
package quki.algorithm.scpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2차 DP: dp[i][k] = i번째 돌까지 마지막에 k번 점프했을때 경우의수
 * dp[i+k][k]= dp[i] - dp[i][k]
 * for(int i=0;i<N;i++)
for(int k=0;k<=K;k++)
for(int j=1;j<=K;j++)
dp[i+j][j]+=dp[i][k];
 * @author quki
 *
 */
public class P2 {

    public static class Point {
        int vertex;

        int prevPath;

        Point(int vertex, int prevPath) {
            this.vertex = vertex;
            this.prevPath = prevPath;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도
            // 됩니다.

            int n = sc.nextInt();
            int k = sc.nextInt();
            int l = sc.nextInt();
            int a[] = new int[n + 1];
            while (l-- > 0) {
                int ln = sc.nextInt();
                a[ln] = -1;
            }
            Queue<Point> q = new LinkedList<>();
            for (int i = 1; i <= k; i++) { // 초기화
                if (i <= n && a[i] != -1) {
                    q.add(new Point(i, i));
                    a[i] = a[i] + 1;
                }
            }

            while (!q.isEmpty()) {

                Point p = q.poll();
                int currV = p.vertex;
                int prevPathNum = p.prevPath;
                for (int i = 1; i <= k; i++) {
                    
                    if(i != prevPathNum){
                        int nextV = currV + i;
                        if(nextV <= n && a[nextV] !=-1){
                            q.add(new Point(nextV,i));
                            a[nextV]=a[nextV]+1;
                        }
                    }
                    
                }

            }

            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);
            System.out.println(a[n]%1000000009);
        }
    }

}
