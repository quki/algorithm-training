
package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = 0;
        StringBuffer sb = new StringBuffer();
        boolean isExistAns = true;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int last = 0;
            if (!st.isEmpty())
                last = st.peek();
            
            if (v > last) {
                int input = max;
                for (int j = input + 1; j <= v; j++) {
                    st.push(j);
                    sb.append("+\n");
                }
                max = Math.max(max, v);
                st.pop();
                sb.append("-\n");
            } else if (v == last) {
                st.pop();
                sb.append("-\n");
            } else {
                isExistAns = false;
                break;
            }
        }
        if (isExistAns) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }

}
