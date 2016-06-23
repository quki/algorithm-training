package quki.algorithm.boj;

import java.util.Arrays;
import java.util.Scanner;

public class P1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] temp = new int[n];
        int[] link = new int[1001];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[i] = x;
            temp[i] = x;
        }
        Arrays.sort(temp);
        for(int i =0;i<temp.length;i++){
            link[temp[i]] = i;
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int k = 0; k < a.length; k++) {
            if(index == link[a[k]]){
                index--;
            }else{
                index = link[a[k]];
            }
            sb.append(index);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
