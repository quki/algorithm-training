package quki.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 스티커 문제
 * 
 * @author quki
 *
 */
public class BOJ9465 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int a[][] = new int[3][100001];
            int d[][] = new int[3][100001];
            String line1[] = br.readLine().split(" ");
            String line2[] = br.readLine().split(" ");
            for(int i = 1; i<=2;i++){
                for(int j = 1; j<=N;j++){
                    if(i == 1)
                        a[i][j] = Integer.parseInt(line1[j-1]);
                    if(i==2)
                        a[i][j] = Integer.parseInt(line2[j-1]);
                }
            }
            d[1][1] = a[1][1];
            d[2][1] = a[2][1];
            
            for(int i =2; i<=N;i++){
                d[0][i] = Math.max(d[1][i-1], d[2][i-1]);
                d[1][i] = Math.max(d[0][i-1], d[2][i-1]) +a[1][i];
                d[2][i] = Math.max(d[0][i-1], d[1][i-1]) +a[2][i];
            }
            
            int ans = 0;
            for(int i = 0; i<3; i++){
               ans = Math.max(ans, d[i][N]); 
            }
            System.out.println(ans);
        }
    }

}
