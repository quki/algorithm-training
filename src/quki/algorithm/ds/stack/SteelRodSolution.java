package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ #10799
 * Using Stack
 * Stack에 index를 저장하는 Technic
 * 
 * @author quki
 */
public class SteelRodSolution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().trim();
        int n = a.length();
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for (int i=0; i<n; i++) {
            char c = a.charAt(i);
            if (c == '(') {
                s.push(i);
            } else {
                if (s.peek()+1 == i) {
                    s.pop();
                    ans += s.size();
                } else {
                    s.pop();
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }

}
