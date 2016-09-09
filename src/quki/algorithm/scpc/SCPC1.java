package quki.algorithm.scpc;

import java.math.BigInteger;
import java.util.Scanner;

public class SCPC1 {

	public static int getMin(int k, int depth, int N) {
		
		if (depth == N)
			return k;

		int min = getMin(2 * k, depth + 1, N);
		
		if ((k - 1) % 3 == 0 && (k - 1) / 3 % 2 != 0 && (k - 1) / 3 != 1) {
			min = Math.min(min, getMin((k - 1) / 3, depth + 1, N));
		}

		return min;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			BigInteger max = new BigInteger("2");
			max = max.pow(N);
			int min = getMin(1, 0, N);

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(min + " " + max);
		}
	}

}
