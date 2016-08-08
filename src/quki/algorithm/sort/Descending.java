package quki.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Descending {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{
                5,3,7,1,9
        };
        
        Arrays.sort(a,new Comparator<Integer>() {

            @Override
            public int compare(Integer e1, Integer e2) {
                return e2.compareTo(e1); // Descending order
            }
            
        });
        for(int i = 0; i<a.length ; i++){
            System.out.println(a[i]);
        }
        
    }

}
