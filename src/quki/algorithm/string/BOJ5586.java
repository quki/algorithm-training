package quki.algorithm.string;

import java.util.Scanner;

public class BOJ5586 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int JOI = 0;
		int IOI = 0;
		for (int i = 0; i < input.length()-2; i++) {
			char c = input.charAt(i);
			if (c == 'I') {
				if ("IOI".equals(input.substring(i, i + 3)))
					IOI++;
			} else if (c == 'J') {
				if ("JOI".equals(input.substring(i, i + 3)))
					JOI++;
			}

		}
		
		System.out.println(JOI +"\n" + IOI);
	}

}
