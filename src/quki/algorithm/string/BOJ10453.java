package quki.algorithm.string;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ10453 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		while (N-- > 0) {
			String line[] = sc.nextLine().split(" ");
			String A = line[0];
			String B = line[1];
			
			if (A.length() != B.length()) {
				System.out.println(-1);
			} else if (A.equals(B)) {
				System.out.println(0);
			} else {
				ArrayList<Integer> aList = new ArrayList<>();
				ArrayList<Integer> bList = new ArrayList<>();
				for (int i = 0; i < A.length(); i++) {
					char a = A.charAt(i);
					char b = B.charAt(i);

					if (a == 'a') {
						aList.add(i);
					}

					if (b == 'a') {
						bList.add(i);
					}

				}

				if (aList.size() != bList.size()) {
					System.out.println(-1);
				} else {
					int ans = 0;
					for (int i = 0; i < aList.size(); i++) {
						ans += Math.abs(aList.get(i) - bList.get(i));
					}
					System.out.println(ans);
				}

			}
		}
	}

}
