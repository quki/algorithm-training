package quki.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DescendingOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a,new Comparator<Integer>() {

            @Override
            public int compare(Integer e1, Integer e2) {
                if(e1<e2){
                    return -1;
                }else if(e1==e2){
                    return 0;
                }else{
                    return 1;
                }
            }
            
        });
        for(int i = 0; i<n ; i++){
            System.out.println(a[i]);
            
        }
        
    }

}
