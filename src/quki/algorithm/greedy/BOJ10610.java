package quki.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 그리디 알고리즘이라기 보다 정수론에 가까운 문제 30의 배수 = 2,3,5 모두의 배수여야한다
 * 즉, 10의 배수 이면서 3의배수 3의배수가 되려면 각 자리수의 합이 3의 배수가 되어야한다.
 * 
 * @author quki
 *
 */
public class BOJ10610 {
	/**
	 * 배열 뒤집기 기본적으로 Comparator를 사용하려면 배열의 원소가 Object여야한다. 즉, Integer이기 때문에 배열의
	 * 원소인 int를 정렬시키려면 Comparator는 사용불가.
	 * 
	 * @param a
	 */
	public static void reverseArray(int[] a) {
		for (int i = 0; i * 2 < a.length; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int a[] = new int[line.length()];
		boolean isExistZero = false;
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			int num = Integer.parseInt(String.valueOf(line.charAt(i)));
			a[i] = num;
			sum += num;
			if (num == 0)
				isExistZero = true;
		}

		if (!isExistZero || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			Arrays.sort(a); // 오름차순
			reverseArray(a); // 뒤집어서 내림차순
			StringBuffer sb = new StringBuffer();
			for (int e : a) {
				sb.append(e);
			}
			System.out.println(sb);

		}

	}

}
