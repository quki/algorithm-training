package quki.algorithm.java;

import java.util.HashSet;
import java.util.Iterator;

public class Lotto {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        while(hs.size() != 6){
            int n = (int)(Math.round(Math.random()*45));
            if(n >= 1 && n<=45){
                hs.add(n);
            }
        }
        StringBuffer sb = new StringBuffer();
        Iterator<Integer> iteraor = hs.iterator();
        while(iteraor.hasNext()){
          int e = iteraor.next();
          sb.append(e+" ");
        }
        System.out.println(sb);
        
    }

}
