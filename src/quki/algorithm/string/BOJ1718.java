package quki.algorithm.string;

import java.util.Scanner;
/**
 * 알파벳은 26개 
 * index+1 로 접근함
 * 1 ~ 26
 * @author quki
 *
 */
public class BOJ1718 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				sb.append(' ');
				continue;
			}

			int alphabetNum = a.charAt(i);
			int pwdNum = b.charAt(i % b.length());
			int idx = alphabetNum - pwdNum;
			if (idx > 0) {
				idx = idx + 96;
			} else {
				idx = 26 + idx + 96;
			}

			sb.append((char) idx);
		}
		System.out.println(sb.toString());
	}

}
