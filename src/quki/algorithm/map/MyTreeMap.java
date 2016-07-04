package quki.algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;



/**
 * BOJ #1764
 * Using HashMap
 * @author quki
 */

/* 
 * INPUT !
 * 3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
*/

// Map 은 entry를 이용해서, key와 value를 구분해준다.
public class MyTreeMap {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        TreeMap<String,Integer> tm = new TreeMap<>(new Comparator<String>(){

            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // Descending order
                //return s1.compareTo(s2); // Ascending order
            }
            
        });
        for(int i = 0; i<n;i++){
            String name = br.readLine();
            tm.put(name, 1);
        }
        for(int i = 0; i<m ;i++){
            String name = br.readLine();
            if(tm.get(name)==null){
                tm.put(name, 1);
            }else{
                tm.put(name, 2);
            }
        }
        ArrayList<String> al = new ArrayList<>();
       
        /**
         * entry set
         * 
         * ex)
         * baesangwook=2
         * charlie=1
         * clinton=1
         * obama=1
         * ohhenrie=2
         * 
         */
        for(Map.Entry<String, Integer> entry : tm.entrySet()){
            String name = entry.getKey();
            Integer value = entry.getValue();
            if(value == 2){
                al.add(name);
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(al.size()+"\n");
        for(int i = 0;i<al.size();i++){
            sb.append(al.get(i)+"\n");
        }
        System.out.println(sb);
    }

}
