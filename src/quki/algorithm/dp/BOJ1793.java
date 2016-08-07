package quki.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1793 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line==null) break;
            int n = Integer.parseInt(line);
            BigInteger d[] = new BigInteger[251];
            d[0] = BigInteger.ONE;
            d[1] = BigInteger.ONE;
            for(int i = 2; i<= n;i++){
                d[i] = d[i-1].add(d[i-2].multiply(new BigInteger("2")));
            }
            System.out.println(d[n]);
        }
        
    }
        
}
