package quki.algorithm.boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        Integer[] b = new Integer[n];
        
        for(int i = 0; i<n;i++){
            a[i]  = sc.nextInt();
        }
        for(int i = 0; i<n;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b,new Comparator<Integer>(){

            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1.compareTo(arg0);
            }
            
        });
        int ans = 0;
        for(int i = 0; i<n ; i++){
            ans += a[i]*b[i];
        }
        System.out.println(ans);
    }

}
