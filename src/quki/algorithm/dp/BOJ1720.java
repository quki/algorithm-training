package quki.algorithm.dp;

import java.util.Scanner;

public class BOJ1720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[][] = new int[2][31];
        d[0][1] = 1;   //d[0][]: 중복을 허용, d[1][]: 중복 허용X
        d[1][1] = 1;
        d[0][2] = 3;
        d[1][2] = 3;
        for(int i = 3; i<=n;i++){
            d[0][i] = d[0][i-1] + d[0][i-2]*2;
            
            int b = 0;
            if(i%2 == 1){
                b = d[0][i/2];
            }else{
                b = d[0][i/2] + d[0][i/2-1]*2;
            }
                d[1][i] = (d[0][i] - b)/2 +b;
        }
        
        System.out.println(d[1][n]);
    }

}
