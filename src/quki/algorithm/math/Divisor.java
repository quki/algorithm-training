
package quki.algorithm.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Divisor {

    public static ArrayList<Integer> getDivisor(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i*i<=n;i++){
            if(n % i == 0){
                al.add(i);
                if(i*i != n)
                al.add(n/i);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> result = getDivisor(n);
        Collections.sort(result);
        if(k > result.size()){
            System.out.println(0);
        }else{
            System.out.println(result.get(k-1));
        }
        
    }
}
