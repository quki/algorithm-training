package quki.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Ascending {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());
        //ArrayList<Integer> al = new ArrayList<>();
        int a[] = new int[n];
        for(int i = 0;i<n;i++){
            int e = Integer.valueOf(br.readLine());
           // al.add(e);
            a[i] = e;
        }
        Arrays.sort(a);
        for( int e : a ){
            bw.write(e + "\n");
        }
        bw.flush();
    }
}
