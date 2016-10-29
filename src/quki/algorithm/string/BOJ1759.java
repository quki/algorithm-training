package quki.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ1759 {
	static int L,C;
	static String a[];
	static HashSet<String> aeiou;

	static boolean check(String str) {

		int aCount = 0;
		int splCount = 0;
		for (int i = 0; i < str.length(); i++) {
			String c = Character.toString(str.charAt(i));
			if (aeiou.contains(c)) {
				aCount++;
			} else {
				splCount++;
			}
		}

		if (aCount >= 1 && splCount >= 2) {
			return true;
		} else {
			return false;
		}
	}

	static void go(String str, int lastIdx) {

		if (str.length() == L) {

			if (check(str)) {
				System.out.println(str);
			}
			return;
		}
		
		for(int i = lastIdx +1 ; i<a.length; i++){
			StringBuilder temp = new StringBuilder(str);
			temp.append(a[i]);
			go(temp.toString(), i);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		a = sc.nextLine().split(" ");
		Arrays.sort(a);
		aeiou = new HashSet<>();
		aeiou.add("a");
		aeiou.add("e");
		aeiou.add("i");
		aeiou.add("o");
		aeiou.add("u");

		for (int i = 0; i < C; i++) {
			go(a[i], i);
		}

	}

}
