package quki.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 에라토스테네스의 채
 * 입력 수의 제한이 있을때
 * O(nloglogn)
 * 
 * @author quki
 *
 */
public class PrimeNumberEratos {

	public static void main(String[] args) {

		int N = 10000; // 10000의 수 까지 소수 판별을 하고 싶다.
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		isPrime[1] = false;
		
		Scanner sc = new Scanner(System.in);
		int question = sc.nextInt();
		
		if(isPrime[question]){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}

	}

}
