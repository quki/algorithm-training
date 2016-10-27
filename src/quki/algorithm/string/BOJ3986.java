package quki.algorithm.string;

import java.util.Scanner;
import java.util.Stack;
/**
 * 좋은 단어
 * 
 * @author quki
 *
 */
public class BOJ3986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		int count = 0;
		while (T-- > 0) {
			String a = sc.nextLine();
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < a.length(); i++) {
				
				char c = a.charAt(i);
				
				if(st.isEmpty()){
					st.push(c);
				}else{
					if(st.peek() == c){
						st.pop();
					}else{
						st.push(c);
					}
				}
			
			}

			if(st.size() == 0){
				count++;
			}
		}

		System.out.println(count);
	}

}
