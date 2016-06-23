package quki.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StringLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[]{
                "d","cc","bbb","aaaa"
        };
        Arrays.sort(s);
        System.out.println(Arrays.toString(s)); // a -> b -> c order
        Arrays.sort(s,new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length()){
                    return -1;
                }else if(s1.length() == s2.length()){
                    return 0;
                }else{
                    return 1;
                }
            }
            
        });
        System.out.println(Arrays.toString(s)); // d -> cc -> bbb (string length order)
    }

}
