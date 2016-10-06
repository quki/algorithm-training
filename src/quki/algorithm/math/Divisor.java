
package quki.algorithm.math;

import java.util.Scanner;
import java.util.TreeSet;

public class Divisor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 1; i * i <= input; i++) {
			if (input % i == 0) {
				ts.add(i);
				ts.add(input / i);
			}
		}
		StringBuilder ans = new StringBuilder();
		for (int e : ts) {
			ans.append(e);
			ans.append(" ");
		}
		System.out.println(ans);

	}
}
