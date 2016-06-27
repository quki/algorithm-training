
package quki.algorithm.sort;

import java.util.Scanner;
import java.util.TreeSet;

public class P10867 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(sc.nextInt());
        }
        StringBuffer sb = new StringBuffer();
        for(int e : ts){
            sb.append(e+" ");
        }
        System.out.println(sb);
    }

}
