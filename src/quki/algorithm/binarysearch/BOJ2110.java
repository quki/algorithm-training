package quki.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분 탐색,공유기 설치 문제
 * N * log(공유기 사이 최대 거리)
 * 
 * @author quki
 *
 */
public class BOJ2110 {
	/**
	 * 매우 중요한 알고리즘이 담겨있는 함수 Greedy의 개념이 담겨있는 알고리즘이므로 잘 생각해보기 바람.
	 * 
	 * @return 만들수 있으면 true
	 */
	public static boolean isPossible(int[] a, int C, int mid) {
		int count = 1;
		int pivot = a[0];
		for (int house : a) {
			if (house - pivot >= mid) {
				pivot = house;
				count++;
			}
		}
		return count >= C;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);

		// left와 right를 통해 인접한 최대거리를 찾는다.
		// 초기 left 는 최소거리인 1, right는 최대거리인 마지막항-첫째항
		int left = 1;
		int right = a[N - 1] - a[0];
		int ans = 1;

		// while 문 조건 잘 생각해볼것
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isPossible(a, C, mid)) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
