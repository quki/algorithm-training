package quki.algorithm.math;

import java.io.IOException;
import java.util.Scanner;

/**
 * BOJ #1357
 * @author quki
 *
 */
public class ReverseAdd {
    
    public static int getReverseVal(String n){
        char[] c = n.toCharArray();
        char temp = ' ';
        int length = c.length;
        if(length == 2){ // 예외 처리
            temp = c[0];
            c[0] = c[1];
            c[1] = temp;
        }else{
            for(int i = 0; i*i < length; i++){
                temp = c[i];
                c[i] = c[length-1-i];
                c[length-1-i] = temp;
            }
        }
        StringBuffer sb = new StringBuffer();
        for( char e :  c){
            sb.append(e);
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
       System.out.println(getReverseVal(""+(getReverseVal(x)+getReverseVal(y))));
    }

}
