package quki.algorithm.math;

import java.util.Scanner;
/**
 * O(sqrt(N))
 * 
 * @author quki
 *
 */
public class IsPrime {
	private static boolean isPrime(int num) {
		if (num == 1)
			return false;

		if ((num % 2) == 0)
			return (num == 2);

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int num = sc.nextInt();
			if (isPrime(num)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
