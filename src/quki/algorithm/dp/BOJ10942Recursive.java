package quki.algorithm.dp;

import java.util.Scanner;

/**
 * 팰린드룸?
 * 재귀 (느림)
 * 참고!
 * 재귀 호출의 시간복잡도는 불리는 횟수에 좌우됨.
 * 그러므로 O(N)
 * 하지만, 데이터의 개수가 M이므로,
 * O(NM)
 * 
 * cf) Manacher's algorithm 는 O(N+M)
 * @author quki
 *
 */
public class BOJ10942Recursive {
    
    public static boolean isPalindrome(int[] a, int start, int end){
        
        if(start == end)return true;
        if(start+1 == end){
           if( a[start] == a[end] ){
               return true;
           }else{
               return false;
           }
        }
        
        if(a[start] == a[end]){
            return isPalindrome(a, start+1, end-1);
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n;i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        while(m-->0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ans = isPalindrome(a, start-1, end-1) ? 1:0;
            System.out.println(ans);
        }
    }

}
