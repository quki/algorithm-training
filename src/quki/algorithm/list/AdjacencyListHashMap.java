package quki.algorithm.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Adjacency List using java
 * Making Bidirectional graph
 * ex) number: Vertex
 * 1 <-> 2,4,6
 * 2 <-> 3,4
 * 
 * @author quki
 *
 */
public class AdjacencyListHashMap {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int n = sc.nextInt(); // number of vertex
        for(int i = 0; i<=n;i++){
            hm.put(i, new ArrayList<Integer>()); // initialize HashMap
        }
        int m = sc.nextInt(); // number of graph info
        while(m-->0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            hm.get(u).add(v);
            hm.get(v).add(u);
        }
        for(int i = 0;i<hm.size();i++){
            System.out.println(hm.get(i));
        }
        
    }

}
