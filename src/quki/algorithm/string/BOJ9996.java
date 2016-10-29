package quki.algorithm.string;

import java.util.Scanner;
/**
 * 패턴에서 * 은 항상 가운데 하나만 나옴
 * 특수문자 split할 때 \\ 붙일 것!
 * 반례는 비교대상이 패턴보다 더 짧은 경우
 * 
 * @author quki
 *
 */
public class BOJ9996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		String[] pattern = sc.nextLine().split("\\*");
		String head = pattern[0];
		String tail = pattern[1];
		while (T-- > 0) {
			String cmp = sc.nextLine();
			boolean isMatch = true;

			if (head.length() + tail.length() > cmp.length()) {
				isMatch = false;
			}

			// head 검사
			if (isMatch) {
				for (int i = 0; i < head.length(); i++) {
					if (cmp.charAt(i) != head.charAt(i)) {
						isMatch = false;
						break;
					}
				}
			}

			// tail 검사
			if (isMatch) {
				for (int i = 0; i < tail.length(); i++) {

					int forCmpIdx = cmp.length() - tail.length() + i;

					if (cmp.charAt(forCmpIdx) != tail.charAt(i)) {
						isMatch = false;
						break;
					}
				}
			}

			if (isMatch) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}

		}
	}

}
