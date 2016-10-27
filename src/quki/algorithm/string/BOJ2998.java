package quki.algorithm.string;

import java.util.Scanner;

public class BOJ2998 {
	/**
	 * 3자리의 2진수를 10진수로
	 */
	public static String getNum(String p) {
		int ret = 0;
		for (int i = 0; i < 3; i++) {
			if (p.charAt(i) == '1') {
				ret += (1 << (2 - i));
			}
		}

		return Integer.toString(ret);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringBuilder sb = new StringBuilder(input);
		sb = sb.reverse();
		while (sb.toString().length() % 3 != 0) {
			sb.append("0");
		}
		String newStr = sb.reverse().toString();

		StringBuilder temp = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < newStr.length(); i++) {
			temp.append(newStr.charAt(i));
			if ((i + 1) % 3 == 0) {
				String oct = getNum(temp.toString());
				ans.append(oct);
				temp.setLength(0);
			}
		}

		System.out.println(ans);

	}

}
