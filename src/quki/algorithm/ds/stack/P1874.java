
package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        StringBuffer sb = new StringBuffer();
        boolean isExistAns = true;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (count < v) {
                int input = count;
                for (int j = input + 1; j <= v; j++) {
                    st.push(j);
                    count++;
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
            } else {
                int last = 0;
                if (!st.isEmpty())
                    last = st.peek();
                if (last != v) {
                    isExistAns = false;
                    sb = null;
                    break;
                } else {
                    st.pop();
                    sb.append("-\n");
                }

            }
        }
        if(isExistAns){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
        

    }

}
