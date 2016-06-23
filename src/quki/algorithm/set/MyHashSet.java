
package quki.algorithm.set;

import java.util.HashSet;
import java.util.Scanner;

/**
 * BOJ #10815
 * Using HashSet
 * @author quki
 *
 */
public class MyHashSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(sc.nextInt());
        }
        int m = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while(m-->0){
            int c = sc.nextInt();
            if(hs.contains(c)){
                sb.append(1+" ");
            }else{
                sb.append(0+" ");
            }
        }
        System.out.println(sb);
    }

}
