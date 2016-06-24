package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ #9012
 * Using Stack
 * @author quki
 *
 */
public class Brace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        while(n-->0){
            Stack<Character> st = new Stack<>();
            String line = sc.nextLine();
            for(int i = 0; i<line.length();i++){
                char c = line.charAt(i);
                if(c == '('){
                    st.push(c);
                }else if(c == ')'){
                    if(!st.isEmpty()){
                        st.pop();
                    }else{
                        st.push(')');
                        break;
                    }
                }
            }
            if(st.size()==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
