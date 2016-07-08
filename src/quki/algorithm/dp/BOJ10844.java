
package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long d[][] = new long[101][10];

        for(int j =1; j<=9;j++) d[1][j] = 1; // 첫재항 초기화
        
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                    long add = 0;

                    if (j - 1 >= 0)
                        add += d[i - 1][j - 1];

                    if (j + 1 <= 9)
                        add += d[i - 1][j + 1];
                    
                    d[i][j] = add % 1000000000;
            }
        }
        long ans = 0;
        for(int i = 0; i<=9; i++){
            ans += d[N][i]% 1000000000;
        }
        System.out.println(ans% 1000000000);  // MOD계산을 수시로!
    }

}
