
package quki.algorithm.boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1015F {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] temp = new int[n];
        boolean[] c = new boolean[n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            a[i] = e;
            temp[i] = e;
        }
        Arrays.sort(temp);
        for(int i = 0; i<n;i++){
            hm.put(i, temp[i]); // key: index, val: a[] element
        }
        
        //ArrayList<Integer> al = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<n; i++){
            for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
                if(a[i] == entry.getValue()){
                    // al.add(entry.getKey());
                    if(!c[entry.getKey()]){
                        sb.append(entry.getKey()+" ");
                        c[entry.getKey()] = true;
                        break;
                    }
                 }
            }
        }
        
        System.out.println(sb);
        
    }

}
