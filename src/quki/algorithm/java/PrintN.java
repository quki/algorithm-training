package quki.algorithm.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrintN {

    public static void main(String[] args) throws IOException{
       Scanner sc = new Scanner(System.in);
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] line = br.readLine().split(" ");
       int sum = 0;
       for(int i = 0; i<line.length; i++){
           sum += Integer.parseInt(line[i]);
       }
       System.out.println(sum);
    }

}
