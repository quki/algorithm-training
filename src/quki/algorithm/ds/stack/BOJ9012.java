package quki.algorithm.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * °ýÈ£ ¹®Á¦
 * 
 * @author quki
 *
 */
public class BOJ9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		while (n-- > 0) {
			String line = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			boolean isNO = false;
			for (int i = 0; i < line.length(); i++) {
				char brace = line.charAt(i);
				if (brace == '(') {
					stack.push('(');
				} else {
					if (stack.size() == 0) {
						isNO = true;
						break;
					}
					stack.pop();
				}
			}
			
			if(stack.size() != 0 || isNO){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}


		}
	}

}
