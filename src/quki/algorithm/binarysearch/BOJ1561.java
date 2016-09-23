package quki.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 이분탐색의 끝판왕, 범위 개념이 들어가서 start, end를 활용함.
 * 
 * @author quki
 *
 */
public class BOJ1561 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int a[] = new int[M]; // 놀이기구 운영시간
		for (int i = 0; i < M; i++) {
			a[i] = sc.nextInt();
		}

		long left = 0; // 최소 분
		long right = 2000000000L * 10000L; // 최대 분
		ArrayList<Integer> al = new ArrayList<>(); // 몇번째인지 알아내기 위해
		int ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			
			// ex) start <= N <= end (중요!)
			long start = 0; 
			long end = 0;
			
			for (int i = 0; i < M; i++) {
				end += (mid / a[i]);
				end++;
				if (mid % a[i] == 0) {
					start--;
				}
			}
			start = start + end + 1;

			if (N < start) { // start보다 작으면 더 줄여야하므로
				right = mid - 1;
			} else if (N > end) { // end보다 크면 더 증가시켜야하므로
				left = mid + 1;
			} else { // 범위에 들어왔으므로 답을 찾을 수 있다!
				for (int i = 0; i < M; i++) {
					if (mid % a[i] == 0) {
						al.add(i);
					}
				}

				ans = al.get((int) (N - start));
				break;
			}
		}
		System.out.println(ans + 1);

	}

}
