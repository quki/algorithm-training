package quki.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 많진 않지만 꼼꼼한 예외처리가 필요함
 * 양수, 음수, 0, 1을 나누는 테크닉
 * 
 * @author quki
 *
 */
public class BOJ1744 {

	static Comparator cmp = new Comparator<Integer>() {

		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1);
		}

	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int zero = 0;
		int one = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a > 0) {
				if (a == 1) {
					one++;
				} else {
					plus.add(a);
				}

			} else if (a == 0) {
				zero++;
			} else {
				minus.add(a);
			}
		}

		Collections.sort(plus, cmp); // 내림차순 정렬
		Collections.sort(minus); // 오름차순 정렬
		int ans = 0;

		// 양수 계산
		// 개수가 홀수라면 1을 추가해주자
		if (plus.size() % 2 == 1) {
			plus.add(1);
		}
		for (int i = 0; i < plus.size() - 1; i = i + 2) {
			int curr = plus.get(i);
			int next = plus.get(i + 1);
			ans += (curr * next);
		}
		ans += one;

		// 음수 계산
		// 개수가 홀수라면 0과 가장 큰수를 곱하자(제거하자)
		// 단, 0이 없는 경우에는 1을 추가해주자
		if (minus.size() % 2 == 1) {
			if (zero > 0) {
				int last = minus.remove(minus.size()-1);
			} else {
				minus.add(1);
			}
		}
		for (int i = 0; i < minus.size() - 1; i = i + 2) {
			int curr = minus.get(i);
			int next = minus.get(i + 1);
			ans += (curr * next);
		}
		
		System.out.println(ans);

	}

}
