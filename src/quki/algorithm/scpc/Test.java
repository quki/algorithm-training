package quki.algorithm.scpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        int T;
        int test_case;
        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int k = sc.nextInt();
            HashMap<Integer,TreeSet<Double>> hm = new HashMap<>();
            for(int i =0; i<=63;i++){
                hm.put(i, new TreeSet<Double>());
            }
            double max = 0;
            double min = 1000000000;
            Queue<Double> q = new LinkedList<>();
            q.add((double)1);
            for(int i = 0; i<k;i++){
                int size = q.size();
                for( int j = 0; j<size; j++){ // 다음항에 채울거
                        double x = q.poll();
                        q.add(2*x);
                        hm.get(i+1).add(2*x);
                        double newX = (x-1)/3;
                        double r = (x-1)%3;
                        if(r==0 && newX!=1 && newX%2 != 0){
                            q.add(newX);
                            hm.get(i+1).add(newX);
                        }
                }
            }
            min =  hm.get(k).first();
            max = hm.get(k).last();
            long minAns = (long)min;
            long maxAns = (long)max;
            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);
            //System.out.println(minAns + " " + maxAns);
            System.out.println("====="+k);
            TreeSet<Double> ts = hm.get(k);
            for(double e: ts){
                long s = (long)e;
                System.out.println(s);
            }
        }
    }


}
