package quki.algorithm.string.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * KMP, O(N+M): N: text 길이, M: pattern 길이, pi 구하는데 O(M) + text 길이 만큼 for문 O(N)
 *
 */
public class BOJ1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();

		ArrayList<Integer> ans = kmp(text, pattern);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size() + "\n");

		for (int index : ans) {
			sb.append(index + " ");
		}
		System.out.println(sb.toString());
	}

	public static ArrayList<Integer> kmp(String text, String pattern) {

		int[] pi = getPi(pattern);

		ArrayList<Integer> list = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < text.length(); i++) {

			// 중간 단계 뛰어넘기
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1]; // index - 1 : 일치하지 않는 문자 바로 앞
			}
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					// j는 비교 인덱스로써, 인덱스가 찾을 문자열의 크기에 도달하면 문자열 찾음.
					list.add(i - pattern.length() + 2);

					// 여러 개의 찾을 문자열이 있을 수 있기 때문.
					j = pi[j];
				} else {
					j++;
				}
			}
		}

		return list;
	}

	/**
	 * pattern의 pi 배열 구하기, 역시 KMP 원리 이용
	 */
	public static int[] getPi(String pattern) {

		int j = 0;
		int[] pi = new int[pattern.length()];

		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}

		}
		return pi;

	}

}
