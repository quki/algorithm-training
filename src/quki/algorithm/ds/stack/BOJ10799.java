package quki.algorithm.ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괄호 자르기, 다시 안풀어도 될듯
 * 
 * @author quki
 *
 */
public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int count = 0;
		int ans = 0;
		for (int i = 1; i < line.length(); i++) {
			char prev = line.charAt(i - 1);
			char curr = line.charAt(i);
			if (prev == '(' && curr == '(') {
				count++;
			}

			if (prev == '(' && curr == ')') {
				ans += count;
			}

			if (prev == ')' && curr == ')') {
				count--;
				ans++;
			}

		}

		System.out.println(ans);

	}

}
