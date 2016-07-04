
package quki.algorithm.graph.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int F = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int G = Integer.parseInt(line[2]);
        int U = Integer.parseInt(line[3]);
        int D = Integer.parseInt(line[4]);

        int dx[] = {
                U, -D
        };
        int a[] = new int[F+1];
        boolean c[] = new boolean[F+1];
        int inf = 1000000000;
        Arrays.fill(a, inf);
        Queue<Integer> q =new LinkedList<>();
        q.add(S);
        c[S] = true;
        a[S] = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            for (int k = 0; k < dx.length; k++) {
                int newX = x + dx[k];
                if(newX>=1 && newX<=F){
                    if(!c[newX]){
                        c[newX] = true;
                        q.add(newX);
                        a[newX] = Math.min(a[newX], a[x]+1);
                    }
                }
            }
        }
        if(a[G] == inf){
            System.out.println("use the stairs");
        }else{
            System.out.println(a[G]);
        }
        

    }

}
