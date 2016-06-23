package quki.algorithm.map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * BOJ #1076
 * Using HashMap
 * @author quki
 *
 */
public class MyHashMap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("black", 0);
        hm.put("brown", 1);
        hm.put("red", 2);
        hm.put("orange", 3);
        hm.put("yellow", 4);
        hm.put("green", 5);
        hm.put("blue", 6);
        hm.put("violet", 7);
        hm.put("grey", 8);
        hm.put("white", 9);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        long ans = hm.get(s1)*10+hm.get(s2);
        int n  = 1;
        for(int i = 0; i<hm.get(s3);i++){
            n*=10;
        }
        ans *= n;
        System.out.println(ans);
    }
}
