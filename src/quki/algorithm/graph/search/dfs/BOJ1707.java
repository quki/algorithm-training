
package quki.algorithm.graph.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 이분그래프 만들기
 * 
 * @author quki
 */
public class BOJ1707 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                hm.put(i, new ArrayList<Integer>());
            }
            int aSet = 2;
            int bSet = 3; // a집합과 b집합으로 나눈다.
            char a[] = new char[n+1];
            Arrays.fill(a, ' ');
            boolean c[] = new boolean[n+1];
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                hm.get(u).add(v);
                hm.get(v).add(u);
                
                
                
                
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(aSet);
            a[aSet] = 'a';
            a[bSet] = 'b';
            c[aSet] = true; // 시작은 aSet부터
            boolean isBinaryGraph = true;
            while(!q.isEmpty() && isBinaryGraph){
                int x = q.poll();
                for(int y: hm.get(x)){
                    if(!c[y]){
                        if(a[x] == aSet){
                            System.out.println("!!");
                            if(a[y] == aSet){
                                System.out.println("!!!");
                                isBinaryGraph = false;
                                break;
                            }else{
                                a[y] = bSet;
                            }
                            
                        }else if(a[x] == bSet){
                            if(a[y] == bSet){
                                isBinaryGraph = false;
                                break;
                            }else{
                                a[y] = aSet;
                            }
                        }
                        c[y] = true;
                        q.add(y);
                    }
                }
            }
            if(isBinaryGraph){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
