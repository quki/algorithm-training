package quki.algorithm.math;

import java.util.Scanner;

public class AddCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int temp = n;
        while(true){
            count++; 
            int ten = temp/10;
            int one = temp%10;
            String a = one+""+(ten+one)%10;
            temp = Integer.valueOf(a);
            if(temp == n){
                   break;
            }
        }
        System.out.println(count);
    }

}
