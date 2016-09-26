package quki.algorithm.graph.search.perfect;

import java.util.Scanner;
/**
 * 완전탐색 중 어려운 문제
 * for문의 범위 잡아주는 생각이 어려움.
 * 그리고 100에서 시작하는 초기값 설정하는 사고가 어려움
 * 우선 이해가 어려우면 자리수 구하는 테크닉이랑 아이디어 위주로 살펴보자
 * 
 * @author quki
 *
 */
public class BOJ1107 {

	/**
	 * 해당 수 c로 바로가는 버튼을 누를 수 있을 때, 자리수를 return한다
	 * 
	 * 모든 자리의수가 깨지지 않았다면 length(자리수)를 return 하나라도 깨진 버튼이 있어서 못 누르면 0 return
	 */
	public static int getLength(boolean broken[], int c) {

		// 자리수 구하는 테크닉!
		// 10 나누면서 count
		int length = 0;
		while (c > 0) {
			int k = c % 10;
			if (broken[k]) {
				return 0;
			}
			c /= 10;
			length++;
		}

		// 예외 처리
		if (c == 0) {
			if (broken[c]) {
				return 0;
			} else {
				return 1;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean broken[] = new boolean[10];
		while (M-- > 0) {
			int a = sc.nextInt();
			broken[a] = true;
		}
		int ans = N - 100; // 초기값을 100에서 숫자를 누르지 않고 이동하는 횟수 
		if (ans < 0) {
			ans = -ans; // n < 100
		}
		for (int i = 0; i <= 1000000; i++) {
			
			int length = getLength(broken, i);
			
			if (length > 0) {
				int plus = N - i; //+,- 버튼! 어차피 동시에 두개가 쓰일 순 없다.
				if (plus < 0) {
					plus = -plus;
				}
				length += plus;
				ans = Math.min(length, ans);
			}

		}
		System.out.println(ans);

	}

}
