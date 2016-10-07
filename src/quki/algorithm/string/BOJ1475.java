package quki.algorithm.string;

import java.util.Scanner;

public class BOJ1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int a[] = new int[9]; // 0 ~ 8까지 있음
		int setCount = 0;

		for (int i = 0; i < input.length(); i++) {
			int num = Integer.parseInt(Character.toString(input.charAt(i)));

			if (num == 9)
				num = 6;

			if (a[num] == 0) {
				setCount++;
				for (int k = 0; k < a.length; k++) {
					a[k]++;
					if (k == 6)
						a[k]++;
				}

			}
			
			a[num]--;

		}
		System.out.println(setCount);

	}

}
