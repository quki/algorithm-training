package quki.algorithm.boj;

import java.util.Scanner;
/**
 * 군수열
 * @author quki
 *
 */
public class P1292 {
    
    public static int getSum(int a){
        int n = (int)Math.sqrt(a*2); // n군
        if(n*(n+1)/2 > a){
            n = n-1;
        }
        int ns = a - n*(n+1)/2; // n+1군에서의 갯수 
        int sum = n*(n+1)*(2*n+1)/6 +(n+1)*ns;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int ans =getSum(end) -  getSum(start-1);
        System.out.println(ans);
    }

}
