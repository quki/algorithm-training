package quki.algorithm.java;

import java.util.Scanner;

public class PrintN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i =1;i<=n;i++){
            sb.append(i);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
