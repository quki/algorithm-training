package quki.algorithm.list;

import java.util.ArrayList;
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
public class AdjacencyListArray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ab = new int[100];
        int n = sc.nextInt(); // number of vertex
        ArrayList<Integer>[] a = (ArrayList<Integer>[])new ArrayList[n];
        for(int i = 0; i<=n;i++){
            a[i] = new ArrayList<Integer>(); // initialize HashMap
        }
        int m = sc.nextInt(); // number of graph info
        while(m-->0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
